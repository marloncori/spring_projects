package org.drmas.online_shop.controllers;

import org.drmas.online_shop.models.Cart;
import org.drmas.online_shop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/addCartToUser/{userId}")
    Cart addCartToUser(@RequestBody Cart cart,
                       @PathVariable Long userId){
      return cartService.addCartToShopUser(cart, userId);
    }

    @DeleteMapping("/deleteCart/{id}")
    void deleteCart(@PathVariable Long id){
        cartService.deleteCart(id);
    }

    @GetMapping("/findCartById/{id}")
    Cart findCartById(@PathVariable Long id){
        return cartService.findCartById(id);
    }

    @DeleteMapping("/removeFromCart/{cartId}/{userId}")
    void removeFromCart(@PathVariable long cartId,
                        @PathVariable long userId){
        cartService.removeFromCart(cartId, userId);
    }

    @GetMapping("/findCartByName/{name}")
    Cart findCartByName(@PathVariable String name){
        return cartService.findByCartName(name);
    }
}
