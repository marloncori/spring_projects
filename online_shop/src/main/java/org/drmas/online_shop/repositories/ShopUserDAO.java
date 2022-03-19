package org.drmas.online_shop.repositories;

import org.drmas.online_shop.models.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopUserDAO extends JpaRepository<ShopUser, Long> {
    Optional<ShopUser> findShopUserByUsername(String username);
}
