package en.amigoscode.jsonwebtoken.service;

import en.amigoscode.jsonwebtoken.domain.AppUser;
import en.amigoscode.jsonwebtoken.domain.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveAppUser(AppUser user);
    Role saveRole(Role role);
    
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}