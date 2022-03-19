package org.drmas.online_shop.dto;

import org.drmas.online_shop.models.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderProductDTO {

    private Product product;
    private Integer quantity;

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
