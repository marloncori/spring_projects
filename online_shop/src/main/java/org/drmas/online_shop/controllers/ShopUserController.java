package org.drmas.online_shop.controllers;

import org.drmas.online_shop.models.ShopUser;
import org.drmas.online_shop.services.ShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ShopUserController {

    @Autowired
    private ShopUserService userService;

    @PostMapping("/addUser")
    ShopUser addUser(@RequestBody ShopUser user) {
        return userService.addShopUser(user);
    }

    @GetMapping("/admin/findAllUsers")
    List<ShopUser> findAllUsers() {
        return userService.findAllShopUsers();
    }

    @PutMapping("/editUser/{id}")
    ShopUser editUser(@RequestBody ShopUser user,
                      @PathVariable Long id) {
        return userService.editShopUser(user, id);
    }

    @GetMapping("/findUserById/{id}")
    ShopUser findUserById(@PathVariable Long id) {
        return userService.findShopUserById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteShopUser(id);
    }

    @GetMapping("/findByUsername/{username}")
    ShopUser findByUsername(@PathVariable String username) {
        return userService.findShopUserByUsername(username);
    }

}
