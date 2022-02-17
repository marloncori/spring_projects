mvpackage com.spring.sample.controller;

import com.spring.sample.model.Person;
import com.spring.sample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*this annotation is need for Spring to know there will be
* clients sending a person to be inserted in the database
*/
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    public final PersonService personService;

    /*Spring injects the actual service into this controller*/
    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    /*GET is for retriving data from your server,
    * POST is for adding a resource to your server,
    * PUT is for modifying data in the server,
    * DELETE is for deleting something from the server
    */
    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person){
        personService.addPerson(person);
    }
    /**
     * this annotation is need for this method to request the
     * body of the JSON file with the person data
    */

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, 
                    @RequestBody Person personToUpdate){
        personService.updatePerson(personToUpdate);
    }
}