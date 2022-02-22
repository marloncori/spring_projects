package pl.millennium.register_and_login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.millennium.register_and_login.details.AppUserDetails;
import pl.millennium.register_and_login.error.UserNotFoundException;
import pl.millennium.register_and_login.model.AppUser;
import pl.millennium.register_and_login.repository.AppUserRepository;

import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            AppUser user = userRepository.findUserByEmail(email);
            return new AppUserDetails(user);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
