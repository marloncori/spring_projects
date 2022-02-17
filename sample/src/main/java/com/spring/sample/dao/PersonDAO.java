mvpackage com.spring.sample.dao;

import java.util.UUID;
import java.util.List;

public interface PersonDAO {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllpeople();

    Optional<Person> selectPersonById(UUID id);
    
    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);

}
