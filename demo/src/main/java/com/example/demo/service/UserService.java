package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(@Qualifier("sampleDAO") UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public int addUser(User user){
        return userDAO.insertUser(user);
    }

    public List<User> getAllUsers(){
        return userDAO.selectAllUsers();
    }

    public Optional<User> getUserById(UUID userID){
        return Optional.of(userDAO.selectUserById(userID));
    }

    public int deleteUser(UUID userId){
        return userDAO.deleteUserById(userId);
    }

    public int updateUser(UUID id, User newUser){
        return userDAO.updateUserById(id, newUser);
    }
}

