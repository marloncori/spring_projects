package en.amigoscode.jsonwebtoken.repository;

import en.amigoscode.jsonwebtoken.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}