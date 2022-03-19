package org.drmas.online_shop.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class ShopUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;
    private boolean admin;

    private String email;
    private String nameOnCard;

    private String cardNumber;
    private int cvv;

    private String address;

    @JsonProperty(access = Access.AUTO)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopUser")
    private List<Category> categories;

    @JsonProperty(access = Access.AUTO)
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "shopUser")
    private List<Cart> carts;

    public ShopUser(){ super();}

    public ShopUser(String username, String password, boolean admin, String email, String nameOnCard, String cardNumber, int cvv, String address, List<Category> categories, List<Cart> carts) {
        super();
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.email = email;
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.address = address;
        this.categories = categories;
        this.carts = carts;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getEmail() {
        return email;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public String getAddress() {
        return address;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public void addCategoryToShopUser(Category category){
        if(getCategories() == null){
            this.categories = new ArrayList<>();
        }
        getCategories().add(category);
        category.setShopUser(this);
    }

    public void addCartToShopUser(Cart cart){
        if(getCarts() == null){
            this.carts = new ArrayList<>();
        }
        getCarts().add(cart);
        cart.setShopUser(this);
    }

    public void removeFromCart(Cart cart){
        if(getCarts() != null){
            getCarts().remove(cart);
        }
    }

}
