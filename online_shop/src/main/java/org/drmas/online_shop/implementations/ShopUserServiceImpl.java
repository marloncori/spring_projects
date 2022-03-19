package org.drmas.online_shop.implementations;

import org.drmas.online_shop.exception.ResourceNotFoundException;
import org.drmas.online_shop.models.ErrMsg;
import org.drmas.online_shop.models.ShopUser;
import org.drmas.online_shop.repositories.ShopUserDAO;
import org.drmas.online_shop.services.ShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ShopUserServiceImpl implements ShopUserService {

    @Autowired
    private ShopUserDAO userDao;

    @Autowired
    private ErrMsg errMsg;

    public ShopUser addShopUser(ShopUser shopUser) {
        Optional<List<ShopUser>> maybeUsers =
                Optional.ofNullable(userDao.findAll());
        if(maybeUsers.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getUserAbsent());
        }
        if (maybeUsers.get().size() == 0) {
            shopUser.setAdmin(true);
        }
         for (ShopUser existUser : maybeUsers.get()) {
            if (shopUser.getUsername().equals(existUser.getUsername())){
                existUser.setUsername(shopUser.getUsername());
                existUser.setPassword(shopUser.getPassword());
                return userDao.save(existUser);
            }
        }
        return userDao.save(shopUser);
    }

    public List<ShopUser> findAllShopUsers() {
        Optional<List<ShopUser>> allUsers =
                Optional.ofNullable(userDao.findAll());
        if(allUsers.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getUserAbsent());
        }
        return allUsers.get();
    }

    public ShopUser editShopUser(ShopUser user, Long id) {
        Optional<ShopUser> existUser = userDao.findById(id);
        if(existUser.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getUserAbsent());
        }
        if(!existUser.get().getUsername().equals(user.getUsername())){
            existUser.get().setUsername(user.getUsername());
        }
        if(!existUser.get().getPassword().equals(user.getPassword())){
            existUser.get().setPassword(user.getPassword());
        }
        existUser.get().setAdmin(user.isAdmin());
        if(!existUser.get().getEmail().equals(user.getEmail())){
            existUser.get().setEmail(user.getEmail());
        }
        if(!existUser.get().getAddress().equals(user.getAddress())){
            existUser.get().setAddress(user.getAddress());
        }
        if(!existUser.get().getNameOnCard().equals(user.getNameOnCard())){
            existUser.get().setNameOnCard(user.getNameOnCard());
        }
        if(existUser.get().getCardNumber() != user.getNameOnCard()){
            existUser.get().setCardNumber(user.getCardNumber());
        }
        if(existUser.get().getCvv() != user.getCvv()){
            existUser.get().setCvv(user.getCvv());
        }
        return userDao.save(existUser.get());
    }

    public ShopUser findShopUserById(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getUserIdFail());
        }
        Optional<ShopUser> maybeUser = userDao.findById(id);
        if(maybeUser.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getUserAbsent());
        }
        return maybeUser.get();
    }

    public void deleteShopUser(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getUserIdFail());
        }
        Optional<ShopUser> maybeUser = userDao.findById(id);
        if(maybeUser.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getUserAbsent());
        }
        userDao.deleteById(maybeUser.get().getId());
    }

    public ShopUser findShopUserByUsername(String username) {
        if(username == null){
            throw new IllegalArgumentException(errMsg.getUserNameEmpty());
        }
        Optional<ShopUser> maybeUser = userDao.findShopUserByUsername(username);
        if(maybeUser.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getUserAbsent());
        }
        return maybeUser.get();
    }

}
