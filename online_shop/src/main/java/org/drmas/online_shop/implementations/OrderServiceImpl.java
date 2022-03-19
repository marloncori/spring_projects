package org.drmas.online_shop.implementations;

import org.drmas.online_shop.exception.ResourceNotFoundException;
import org.drmas.online_shop.models.ErrMsg;
import org.drmas.online_shop.models.Order;
import org.drmas.online_shop.repositories.OrderDAO;
import org.drmas.online_shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ErrMsg errMsg;

    @Override
    public @NotNull Iterable<Order> getAllOrders(){
        Optional<Iterable<Order>> maybeOrders =
                Optional.ofNullable(orderDAO.findAll());
        if(maybeOrders.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getOrdersAbsent());
        }
        return maybeOrders.get();
    }

    @Override
    public Order create(@NotNull(message = "The order cannot be null.") @Valid Order order) {
        return orderDAO.save(order);
    }

    @Override
    public void update(@NotNull(message = "The order cannot be null.") @Valid Order order) {
        orderDAO.save(order);
    }

}
