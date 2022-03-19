package org.drmas.online_shop.controllers;

import org.drmas.online_shop.dto.OrderProductDTO;
import org.drmas.online_shop.exception.ResourceNotFoundException;
import org.drmas.online_shop.models.*;
import org.drmas.online_shop.services.OrderProductService;
import org.drmas.online_shop.services.OrderService;
import org.drmas.online_shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedFormContentFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProductService orderProductService;

    @Autowired
    private ErrMsg error;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> listOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> create(@RequestBody OrderForm form){
        List<OrderProductDTO> dtoForm = form.getOrderProductDtos();
        validateProductsExistance(dtoForm);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
        for(OrderProductDTO dto : dtoForm){
            orderProducts.add(orderProductService.create(new OrderProduct(order,
                    productService.getProduct(dto.getProduct().getId()),
                    dto.getQuantity())));
        }
        order.setOrderProducts(orderProducts);
        orderService.update(order);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);
        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    private void validateProductsExistance(List<OrderProductDTO> orderProducts) {
        List<OrderProductDTO> list = orderProducts
                .stream()
                .filter(op -> Objects.isNull(productService.getProduct(op.getProduct().getId())))
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(list)) new ResourceNotFoundException(error.getProductAbsent());
    }
}
