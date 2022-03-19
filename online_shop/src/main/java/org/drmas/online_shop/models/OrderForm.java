package org.drmas.online_shop.models;

import org.drmas.online_shop.dto.OrderProductDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderForm {

    private List<OrderProductDTO> orderProductDtos;

    public List<OrderProductDTO> getOrderProductDtos(){
        return this.orderProductDtos;
    }

    private void setOrderProductDtos(List<OrderProductDTO> orderProductDtos){
        this.orderProductDtos = orderProductDtos;
    }
}
