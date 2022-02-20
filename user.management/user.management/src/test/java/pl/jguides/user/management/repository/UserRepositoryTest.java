package pl.jguides.user.management.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration;
import org.springframework.test.annotation.Rollback;
import pl.jguides.user.management.model.User;
import pl.jguides.user.management.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp(){
        User user = User.builder()
                .email("yuelami@gmail.com")
                .firstName("Marlon")
                .lastName("Couto")
                .password("Mc0489921")
                .build();

        entityManager.persist(user);
    }

    @Test
    public void testFindById(){
        User newUser = userRepo.findById(1).get();
        assertEquals(newUser.getFirstName(), "Marlon");
    }

    @Test
    public void testFindAll(){
        Iterable<User> users = userRepo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user : users){
            System.out.println("\033[1;33m\n" + user + "\033[0m\n");
        }
        /* List<User> users = (List<User>) userRepo.findAll();
        *  assertEquals(users.isEmpty(), false);
        *
        *  users.stream().forEach(System.out::println); */
    }

    @Test
    public void testAddNew(){
        User user2 = User.builder()
                .firstName("Lazaro")
                .lastName("de Jesus")
                .email("otica_araguaina@hotmail.com")
                .password("poetaDeCDA57")
                .build();

        User savedUser = userRepo.save(user2);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    void testUpdateUser(){
        Integer ID = 1;
        Optional<User> maybeUser = userRepo.findById(ID);
        if (maybeUser.isPresent()){
            User user = maybeUser.get();
            user.setPassword("hello200#");
            userRepo.save(user);
        }
         User updatedUser = userRepo.findById(ID).get();
         assertEquals(updatedUser.getPassword(), "hello200#");
    }

    @Test
    void testGetUser(){
        Integer userID = 1;
        Optional<User> optionalUser = userRepo.findById(userID);
        assertTrue(optionalUser.isPresent());
        /* Assertions.assertThat(optionalUser).isNotPresent();*/
        System.out.println("\033[1;32m\n" + optionalUser.get() + "\033[0m\n");
    }

    @Test
    void testDeleteUser(){
        Integer userID = 1;
        userRepo.deleteById(userID);
        Optional<User> optionalUser = userRepo.findById(userID);
        assertFalse(optionalUser.isPresent());
        /* Assertions.assertThat(optionalUser).isNotPresent();*/
    }
}
