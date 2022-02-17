package pl.millenium.mvctutorial.model;

import com.springframework.stereotype. ;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity;
public class Robot {

    private final @Id @GeneratedValue
    Long id;

    private String name;
    
    private String type;

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public void setName(){
        return name;
    }

    public void setType(){
        return type;
    }
}
