package org.drmas.online_shop.services;

import org.drmas.online_shop.models.Product;

import java.util.List;

public interface ProductService {
    Product addProductToCategory(Product product, Long idCategory);
    Product editProduct(Product product, Long id);
    Product findProductById(Long id);
    void deleteProduct(Long id);
    List<Product> findAllProducts();
    List<Product> findProductsForCategory(Long idCategory);
    Product getProduct(Long id);
}
