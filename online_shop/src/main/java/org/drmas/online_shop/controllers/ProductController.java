package org.drmas.online_shop.controllers;

import org.drmas.online_shop.models.Product;
import org.drmas.online_shop.repositories.ProductDAO;
import org.drmas.online_shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDAO productDao;

    @PostMapping("/addProductToCategory/{idCategory}")
    Product addProductToCategory(@RequestBody Product product,
                                 @PathVariable Long idCategory) {
        return productService.addProductToCategory(product, idCategory);
    }

    @PutMapping("/editProduct/{id}")
    Product editProduct(@RequestBody Product product,
                        @PathVariable Long id) {
        return productService.editProduct(product, id);
    }

    @GetMapping("/findProductById/{id}")
    Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/findAllProducts")
    List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/findProductsForCategory/{idCategory}")
    List<Product> findProductsForCategory(@PathVariable Long idCategory) {
        return productService.findProductsForCategory(idCategory);
    }

    @GetMapping("/findByName/{name}")
    List<Product> findByName(@PathVariable String name) {
        return productDao.findByName("%" + name + "%");
    }

}
