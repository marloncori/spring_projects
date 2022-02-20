package pl.jguides.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jguides.user.management.error.UserAlreadySavedException;
import pl.jguides.user.management.error.UserNotFoundException;
import pl.jguides.user.management.model.User;
import pl.jguides.user.management.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private String errorMsg1 = "USER has not been found in the database.";
    private String errorMsg2 = "USERS have not been found in the database!";
    private String errorMsg3 = "USER is already present in the database!";

    @Autowired
    UserRepository userRepository;

    public User getUserById(Integer id) throws UserNotFoundException {
        Optional<User> maybeUser = userRepository.findById(id);
        if(!maybeUser.isPresent()){
            throw new UserNotFoundException(errorMsg1);
        }
        return maybeUser.get();
    }
    public List<User> getAllUsers() throws UserNotFoundException {
        List<User> users = (List<User>) userRepository.findAll();
        Optional<List<User>> maybeUsers = Optional.of(users);
        if(!maybeUsers.isPresent()){
            throw new UserNotFoundException(errorMsg2);
        }
        return users;
    }

    public void addUser(User user) throws UserAlreadySavedException {
        List<User> users = (List<User>) userRepository.findAll();
        if(users.contains(user)){
            throw new UserAlreadySavedException(errorMsg3);
        } else {
            userRepository.save(user);
        }
    }

    public void updateUser(User newUser, Integer id) throws UserNotFoundException {
        Optional<User> oldUser = userRepository.findById(id);
        if(!oldUser.isPresent()) {
            throw new UserNotFoundException(errorMsg1);
        } else {
            if(!oldUser.get().getFirstName().equals(newUser.getFirstName())) {
                oldUser.get().setFirstName(newUser.getFirstName());
            }
            if(!oldUser.get().getLastName().equals(newUser.getLastName())) {
                oldUser.get().setLastName(newUser.getLastName());
            }
            if(!oldUser.get().getEmail().equals(newUser.getEmail())) {
                oldUser.get().setEmail(newUser.getEmail());
            }
            if(!oldUser.get().getPassword().equals(newUser.getPassword())) {
                oldUser.get().setPassword(newUser.getPassword());
            }
            userRepository.save(oldUser.get());
        }
    }

    public void deleteUser(Integer id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) throw new UserNotFoundException(errorMsg1);
        userRepository.deleteById(id);
    }
}
