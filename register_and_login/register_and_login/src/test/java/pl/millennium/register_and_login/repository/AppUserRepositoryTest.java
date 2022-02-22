package pl.millennium.register_and_login.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import pl.millennium.register_and_login.error.UserNotFoundException;
import pl.millennium.register_and_login.model.AppUser;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository userRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        AppUser user = new AppUser();
            user.setEmail("yuelami@gmail.com");
            user.setPassword("mc0489921");
            user.setFirstName("Marlon");
            user.setLastName("Couto");

            AppUser savedUser = userRepo.save(user);
            AppUser existingUser = entityManager.find(AppUser.class, savedUser.getId());
            //assertEquals(savedUser, existingUser);
            Assertions.assertThat(savedUser.getEmail()).isEqualTo(existingUser.getEmail());
    }

}