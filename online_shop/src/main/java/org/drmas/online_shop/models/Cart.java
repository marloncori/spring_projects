package org.drmas.online_shop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private int quantity;
    private String pictureUrl;

    @JsonBackReference(value = "user")
    @ManyToOne
    private ShopUser shopUser;

    public Cart(){
        super();
    }

    public Cart(Long id, String name, Double price, int quantity,
                String pictureUrl, ShopUser shopUser) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.pictureUrl = pictureUrl;
        this.shopUser = shopUser;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public ShopUser getShopUser() {
        return shopUser;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setShopUser(ShopUser shopUser) {
        this.shopUser = shopUser;
    }
}
