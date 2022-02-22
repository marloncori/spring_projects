package pl.millennium.register_and_login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@SpringBootApplication
public class RegisterAndLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterAndLoginApplication.class, args);
	}

}
