package en.amigoscode.jsonwebtoken.repository;

import en.amigoscode.jsonwebtoken.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String username);
}