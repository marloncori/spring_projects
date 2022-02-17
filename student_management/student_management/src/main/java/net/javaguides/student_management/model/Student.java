package net.javaguides.student_management.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    //add a primary key to the DB table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Column(name ="first_name", nullable = false)
    private String firstName;
    
    @Column(name ="last_name", nullable = false)
    private String lastName;
    
    @Column(name ="email", nullable = false)
    private String email;

    //this is a default construtctor needed by Hibernate
    public Student(){

    }
    public Student(Long id, String firstName, String lastname, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }    

    public Long getId(){
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;    
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName; 
    }

    public String getLastName(){
        return lastName;
    }

    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
