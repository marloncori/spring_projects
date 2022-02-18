package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface UserDAO {

    int insertUser(UUID id, User user);
    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();
    Optional<User> selectUserById(UUID id);
    
    int deleteUserById(UUID id);

    int updateUserById(UUID id, User user);
}
