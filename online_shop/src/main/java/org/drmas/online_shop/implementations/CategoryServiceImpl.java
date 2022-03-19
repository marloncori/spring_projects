package org.drmas.online_shop.implementations;

import org.drmas.online_shop.exception.ResourceNotFoundException;
import org.drmas.online_shop.models.Category;
import org.drmas.online_shop.models.ErrMsg;
import org.drmas.online_shop.models.ShopUser;
import org.drmas.online_shop.repositories.CategoryDAO;
import org.drmas.online_shop.repositories.ShopUserDAO;
import org.drmas.online_shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ShopUserDAO shopUserDAO;

    @Autowired
    private ErrMsg error;

    @Override
    public Category addCategoryToShopUser(Category category, Long id){
        if(id == null){
            throw new IllegalArgumentException(error.getCategoryIdFail());
        }
        Optional<ShopUser> maybeUser = shopUserDAO.findById(id);
        if(maybeUser.isEmpty()){
            throw new ResourceNotFoundException(error.getUserAbsent());
        }
        if(category != null) {
            maybeUser.get().addCategoryToShopUser(category);
        } else {
            throw new IllegalArgumentException(error.getCategoryMsgFail());
        }
        return categoryDAO.save(category);
    }

    @Override
    public Category editCategory(Category category, Long id) {
        if(id == null){
            throw new IllegalArgumentException(error.getCategoryIdFail());
        }
        Category maybeCategory = categoryDAO.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(error.getCategoryAbsent()));
        if(category != null) {
            maybeCategory.setName(category.getName());
        } else {
            throw new IllegalArgumentException(error.getCategoryMsgFail());
        }
        return categoryDAO.save(maybeCategory);
    }

    @Override
    public Category findCategoryById(Long id) {
        if(id == null){
            throw new IllegalArgumentException(error.getCategoryIdFail());
        }
        Optional<Category> maybeCategory = categoryDAO.findById(id);
        if(maybeCategory.isEmpty()){
            throw new ResourceNotFoundException(error.getCategoryAbsent());
        }
        return maybeCategory.get();
    }

    @Override
    public void deleteCategory(Long id) {
        if(id == null){
            throw new IllegalArgumentException(error.getCategoryIdFail());
        }
        Optional<Category> maybeCategory = categoryDAO.findById(id);
        if(maybeCategory.isEmpty()){
            throw new ResourceNotFoundException(error.getCategoryAbsent());
        }
        categoryDAO.delete(maybeCategory.get());
    }

    @Override
    public List<Category> findAllCategories() {
        Optional<List<Category>> maybeCategories =
                Optional.ofNullable(categoryDAO.findAll());
        if(maybeCategories.isEmpty()){
            throw new ResourceNotFoundException(error.getCategoryAbsent());
        }
        return maybeCategories.get();
    }

    @Override
    public List<Category> findCategoriesForShopUser(Long userId) {
        if(userId == null){
            throw new IllegalArgumentException(error.getUserIdFail());
        }
        Optional<ShopUser> user = shopUserDAO.findById(userId);
        if(user.isEmpty()){
            throw new ResourceNotFoundException(error.getUserAbsent());
        }
        return user.get().getCategories();
    }

}
