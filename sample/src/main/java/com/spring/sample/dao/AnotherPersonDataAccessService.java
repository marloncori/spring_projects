mvpackage com.spring.sample.dao;

import com.spring.sample.model.Person;
import org.springframework.stereotype.Repository;

import com.spring.sample.dao.PersonDAO;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

/*
*I have to tell Spring that this class will be instaniated
* as bean, so it will be "injected" in other classes
*/
@Repository("postgres")
public class AnotherPersonDataAccessService implements PersonDAO {

        @Override
        public int insertPerson(UUID id, Person person){
            return 0;
        }

        @Override
        public List<Person> selectAllpeople(){
            return List.of(new Person(UUID.randomUUID(), "FROM POSTGRESS DB"));
        }

        @Override
        public Optional<Person> selectPersonById(UUID id){
            return 0;
        }

        @Override
        public int deletePersonById(UUID id){
            return 0;
        }

        @Override
        public int updatePersonById(UUID id, Person update){
            return 0;
        }
        
}