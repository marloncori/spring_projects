package pl.millennium.register_and_login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.millennium.register_and_login.model.AppUser;
import pl.millennium.register_and_login.repository.AppUserRepository;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public void registerUser(AppUser user){
        appUserRepository.save(user);
    }

    public List<AppUser> listAllUsers() { return appUserRepository.findAll(); }
}
