package en.amigoscode.jsonwebtoken.service;

import en.amigoscode.jsonwebtoken.domain.AppUser;
import en.amigoscode.jsonwebtoken.domain.Role;
import en.amigoscode.jsonwebtoken.repository.RoleRepository;
import en.amigoscode.jsonwebtoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
                                                //needed for logs
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUserName(username);
        if(appUser == null){
            log.error("User has not been in the database!");
            throw new UsernameNotFoundException("Requested user has not been saved into the DB yet.");
        } else {
            log.info("User has been successfully found: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getName()));
            });
        return new org.springframework.security.core.userdetails.User(appUser.getUsername(),
                appUser.getPassword(), authorities);
    }

    @Override
    public AppUser saveAppUser(AppUser user){
        log.info("Saving new user called {} to the database...", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role){
        log.info("Saving new role {} to the database...", role.getName());
        return roleRepository.save(role);
    }
    
    @Override
    public void addRoleToUser(String username, String roleName){
        log.info("Adding role {} to user {}...", roleName, username);
        AppUser appUser = userRepository.findByUserName(username);
        Role role = roleRepository.findRoleByName(roleName);
        appUser.getRoles().add(role);
    }
    
    @Override
    public AppUser getUser(String username){
        log.info("Fetching the requested user: {}...", username);
        return userRepository.findByUserName(username);
    }
    
    @Override
    public List<AppUser> getUsers(){
        log.info("Fetching all users saved in the database...");
        return userRepository.findAll();
    }
}