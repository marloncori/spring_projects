package org.drmas.online_shop.services;

import org.drmas.online_shop.models.Cart;

import java.util.List;

public interface CartService {

    Cart addCartToShopUser(Cart cart, Long idUser);
    void deleteCart(Long id);
    List<Cart> findCartsForShopUser(Long idUser);
    Cart findCartById(Long id);
    void removeFromCart(Long idCart, Long idUser);
    Cart findByCartName(String name);

}
