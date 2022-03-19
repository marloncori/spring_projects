package org.drmas.online_shop.repositories;

import org.drmas.online_shop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Long> {

}
