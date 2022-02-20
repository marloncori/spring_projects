package com.jguides.student.registration;

import com.jguides.student.registration.model.Student;
import com.jguides.student.registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jguides.student.registration")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
