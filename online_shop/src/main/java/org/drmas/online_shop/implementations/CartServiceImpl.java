package org.drmas.online_shop.implementations;

import org.drmas.online_shop.exception.ResourceNotFoundException;
import org.drmas.online_shop.models.Cart;
import org.drmas.online_shop.models.ErrMsg;
import org.drmas.online_shop.models.ShopUser;
import org.drmas.online_shop.repositories.CartDAO;
import org.drmas.online_shop.repositories.ShopUserDAO;
import org.drmas.online_shop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDao;
    @Autowired
    private ShopUserDAO userDao;
    @Autowired
    private ErrMsg errMsg;

    @Override
    public Cart addCartToShopUser(Cart cart, Long id){
        if(cart == null || id == null){
            throw new IllegalArgumentException(errMsg.getCartMsgFail());
        }
        Optional<ShopUser> user = userDao.findById(id);
        if(user.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getUserAbsent());
        }
        user.get().addCartToShopUser(cart);
        return cartDao.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getCartIdFail());
        }
        cartDao.deleteById(id);
    }

    @Override
    public List<Cart> findCartsForShopUser(Long idUser) {
            if(idUser == null){
                throw new IllegalArgumentException(errMsg.getUserIdFail());
            }
        Optional<ShopUser> user = userDao.findById(idUser);
            if(user.isEmpty()){
                throw new ResourceNotFoundException(errMsg.getUserAbsent());
            }
        return user.get().getCarts();
    }

    @Override
    public Cart findCartById(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getCartIdFail());
        }
        Optional<Cart> maybeCart = cartDao.findById(id);
        if(maybeCart.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getCartAbsent());
        }
        return maybeCart.get();
    }

    @Override
    public void removeFromCart(Long idCart, Long idUser) {
        if(idUser == null || idCart == null){
            throw new IllegalArgumentException(
                    errMsg.getCartIdFail() + "\n" + errMsg.getUserIdFail()
            );
        }
        Optional<ShopUser> maybeUser = userDao.findById(idUser);
        if(maybeUser.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getUserAbsent());
        }
        Optional<Cart> maybeCart = cartDao.findById(idCart);
        if(maybeCart.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getCartAbsent());
        }
        maybeUser.get().removeFromCart(maybeCart.get());
        cartDao.delete(maybeCart.get());
    }

    @Override
    public Cart findByCartName(String name) {
        if(name == null){
            throw new IllegalArgumentException(errMsg.getCartNameEmpty());
        }
        Optional<Cart> maybeCart = cartDao.findByName(name);
        if (!maybeCart.isPresent()) {
            throw new ResourceNotFoundException(errMsg.getCartAbsent());
        }
        return maybeCart.get();
    }
}
