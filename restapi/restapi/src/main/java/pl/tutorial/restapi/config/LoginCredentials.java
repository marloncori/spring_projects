package pl.tutorial.restapi.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
public class LoginCredentials {

    private String username;
    private String password;
}
