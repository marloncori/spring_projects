package org.drmas.online_shop.services;

import org.drmas.online_shop.models.Order;
import org.drmas.online_shop.models.OrderProduct;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface OrderService {
    @NotNull
    Iterable<Order> getAllOrders();

    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);
    void update (@NotNull(message = "The order cannot be null.") @Valid Order order);
}
