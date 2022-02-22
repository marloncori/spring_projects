package pl.millennium.register_and_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.millennium.register_and_login.error.UserNotFoundException;
import pl.millennium.register_and_login.model.AppUser;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("SELECT usr FROM AppUser usr WHERE usr.email = ?1")
    AppUser findUserByEmail(String email) throws UserNotFoundException;

}
