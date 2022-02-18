package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


import java.util.UUID;

public class User {

    private final UUID id;
    private final String name;
    private final String email;

    public User(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("email") String email){
        this.id = id;
        this.name = name;
        this.email = email;    
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}