package org.drmas.online_shop.services;

import org.drmas.online_shop.models.Category;

import java.util.List;

public interface CategoryService {

    Category addCategoryToShopUser(Category category, Long idUser);

    Category editCategory(Category category, Long id);

    Category findCategoryById(Long id);

    void deleteCategory(Long id);

    List<Category> findAllCategories();

    List<Category> findCategoriesForShopUser(Long id);
}
