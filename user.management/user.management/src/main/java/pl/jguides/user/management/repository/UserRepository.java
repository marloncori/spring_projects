package pl.jguides.user.management.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jguides.user.management.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
