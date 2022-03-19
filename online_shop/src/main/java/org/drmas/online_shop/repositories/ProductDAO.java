package org.drmas.online_shop.repositories;

import org.drmas.online_shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p FROM Product p WHERE p.name = :name")
    List<Product> findByName(String name);
}
