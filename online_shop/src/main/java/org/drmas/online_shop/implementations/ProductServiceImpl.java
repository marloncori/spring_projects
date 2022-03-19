package org.drmas.online_shop.implementations;

import org.drmas.online_shop.exception.ResourceNotFoundException;
import org.drmas.online_shop.models.Category;
import org.drmas.online_shop.models.ErrMsg;
import org.drmas.online_shop.models.Product;
import org.drmas.online_shop.repositories.CategoryDAO;
import org.drmas.online_shop.repositories.ProductDAO;
import org.drmas.online_shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDao;

    @Autowired
    private CategoryDAO categoryDao;

    @Autowired
    private ErrMsg errMsg;

    @Override
    public Product addProductToCategory(Product product, Long idCategory) {
        if(idCategory == null){
            throw new IllegalArgumentException(errMsg.getCategoryIdFail());
        }
        if(product == null){
            throw new IllegalArgumentException(errMsg.getProductMsgFail());
        }
        Optional<Category> category = categoryDao.findById(idCategory);
        if(category.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getCategoryAbsent());
        }
        category.get().addProductToCategory(product);
        categoryDao.save(product.getCategory());
        return productDao.save(product);
    }

    @Override
    public Product editProduct(Product product, Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getCategoryIdFail());
        }
        if(product == null){
            throw new IllegalArgumentException(errMsg.getProductMsgFail());
        }
        Optional<Product> existProduct = productDao.findById(id);
        if(existProduct.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getProductAbsent());
        }
        existProduct.get().setName(product.getName());
        existProduct.get().setDescription(product.getDescription());
        existProduct.get().setPictureUrl(product.getPictureUrl());
        existProduct.get().setPrice(product.getPrice());
        return productDao.save(existProduct.get());
    }

    @Override
    public Product findProductById(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getCategoryIdFail());
        }
        Optional<Product> existProduct = productDao.findById(id);
        if(existProduct.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getProductAbsent());
        }
        return existProduct.get();
    }

    @Override
    public void deleteProduct(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getProductIdFail());
        }
        Optional<Product> existProduct = productDao.findById(id);
        if(existProduct.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getProductAbsent());
        }
        categoryDao.deleteById(existProduct.get().getId());
    }

    @Override
    public List<Product> findAllProducts() {
        Optional<List<Product>> allProducts =
                Optional.ofNullable(productDao.findAll());
        if(allProducts.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getProductAbsent());
        }
        return allProducts.get();
    }

    @Override
    public List<Product> findProductsForCategory(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getCategoryIdFail());
        }
        Optional<Category> maybeCategory = categoryDao.findById(id);
        if(maybeCategory.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getCategoryAbsent());
        }
        return maybeCategory.get().getProducts();
    }

    @Override
    public Product getProduct(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getProductIdFail());
        }
        Optional<Product> product = productDao.findById(id);
        if(product.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getProductAbsent());
        }
        return product.get();
    }

}
