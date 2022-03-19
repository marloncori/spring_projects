package org.drmas.online_shop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonBackReference(value = "user")
    @ManyToOne
    private ShopUser shopUser;

    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products;

    public Category() {
        super();
    }

    public Category(Long id, String name,
                    ShopUser shopUser, List<Product> products) {
        this.id = id;
        this.name = name;
        this.shopUser = shopUser;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ShopUser getShopUser() {
        return shopUser;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShopUser(ShopUser shopUser) {
        this.shopUser = shopUser;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProductToCategory(Product product) {
        if (getProducts()==null) {
            this.products = new ArrayList<Product>();
        }
        getProducts().add(product);
        product.setCategory(this);
    }
}
