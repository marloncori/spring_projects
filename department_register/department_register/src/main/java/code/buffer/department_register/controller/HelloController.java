package code.buffer.department_register.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /* this message will be taken from the
     * application.properties file
     */
    @Value("${welcome.message.config}")
    private String welcomeMsg;

    @GetMapping("/")
    public String hello_api(){
        return welcomeMsg;
    }
}
