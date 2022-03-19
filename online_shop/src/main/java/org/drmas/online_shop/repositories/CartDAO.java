package org.drmas.online_shop.repositories;

import org.drmas.online_shop.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartDAO extends JpaRepository<Cart, Long> {

    Optional<Cart> findByName(String name);
}
