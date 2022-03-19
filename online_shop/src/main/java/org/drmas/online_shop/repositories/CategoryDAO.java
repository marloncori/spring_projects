package org.drmas.online_shop.repositories;

import org.drmas.online_shop.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Long> {

}
