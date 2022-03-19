package org.drmas.online_shop.services;

import org.drmas.online_shop.models.ShopUser;

import java.util.List;

public interface ShopUserService {

    ShopUser addShopUser(ShopUser user);
    List<ShopUser> findAllShopUsers();
    ShopUser editShopUser(ShopUser user, Long id);
    ShopUser findShopUserById(Long id);
    void deleteShopUser(Long id);
    ShopUser findShopUserByUsername(String username);
}
