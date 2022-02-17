mvpackage com.spring.sample.service;

import com.spring.sample.dao.PersonDAO;
import com.spring.sample.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonDAO personDAO;

    /*
    * I am injecting to this
    * I must have a way to distinguish between implementations
    */
    @Autowired       //or@Qualifier("postgres")
    public PersonService(@Qualifier ("sampleDAO") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public int addPerson(Person person){
        return personDAO.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDAO.selectAllpeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDAO.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDAO.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDAO.updatePersonById(id, newPerson);
    }
}