package org.drmas.online_shop.implementations;

import org.drmas.online_shop.models.OrderProduct;
import org.drmas.online_shop.repositories.OrderProductDAO;
import org.drmas.online_shop.services.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Transactional
@Service
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    private OrderProductDAO orderProductDAO;

    @Override
    public OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct) {
        return this.orderProductDAO.save(orderProduct);
    }
}
