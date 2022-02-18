package com.example.demo.dao;

import com.example.demo.model.User;
import com.example.demo.dao.UserDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository("sampleDAO")
public class UserDataAccess implements UserDAO {
    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user){
        DB.add(new User(id, user.getName(), user.getEmail());
        return 1;
    }

    @Override
    public List<User> selectAllUsers(){
        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID userId){
        return DB.stream()
                .filter(usr -> usr.getId().equals(userId))
                .findFirst();
    }

    @Override
    public int deleteUserById(UUID userId){
        Optional<User> userMaybe = selectUserById(userId);
        if(!userMaybe.isPresent()){
            return 0;
        }
        DB.remove(userMaybe.get());
        return 1;
    }

    @Override
    public int updateUserById(UUID userId, User update){
        return selectUserById(userId)
                .map(usr -> {
                    int indexOfUser = DB.indexOf(usr);
                    if(indexOfUser >= 0){
                        DB.set(indexOfUser, new User(userId, update.getName(), update.getEmail());
                        return 1;
                    }
                    return 0;
                }).orElseThrow(new RuntimeException("User has not been found in database."));
    }
}