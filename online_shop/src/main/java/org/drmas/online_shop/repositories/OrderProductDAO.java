package org.drmas.online_shop.repositories;

import org.drmas.online_shop.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductDAO extends JpaRepository<OrderProduct, Long> {
}
