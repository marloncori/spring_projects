package org.drmas.online_shop.controllers;

import org.drmas.online_shop.models.Category;
import org.drmas.online_shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findCategoryById/{id}")
    Category findCategoryById(@PathVariable Long id){
        return categoryService.findCategoryById(id);
    }

    @GetMapping("/findAllCategories")
    List<Category> findAllCategories(){
        return categoryService.findAllCategories();
    }

    @GetMapping("/getCategoriesForUser/{userId}")
    List<Category> getCategoriesForUser(@PathVariable Long userId){
        return categoryService.findCategoriesForShopUser(userId);
    }

    @PostMapping("/addCategoryToUser/{userId}")
    Category addCategoryToUser(@RequestBody Category category,
                               @PathVariable Long userId){
        return categoryService.addCategoryToShopUser(category, userId);
    }

    @PutMapping("editCategory/{id}")
    Category editCategory(@RequestBody Category category,
                          @PathVariable Long id){
        return categoryService.editCategory(category, id);
    }

    @DeleteMapping("deleteCategory/{id}")
    void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
