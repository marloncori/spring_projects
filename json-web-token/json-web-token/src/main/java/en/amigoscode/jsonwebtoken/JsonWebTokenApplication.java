package en.amigoscode.jsonwebtoken;

import en.amigoscode.jsonwebtoken.domain.AppUser;
import en.amigoscode.jsonwebtoken.domain.Role;
import en.amigoscode.jsonwebtoken.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JsonWebTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonWebTokenApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(AppUserService userService){
		return args -> {
			userService.saveRole(new Role(1454871L, "ROLE_USER"));
			userService.saveRole(new Role(1454872L, "ROLE_MANAGER"));
			userService.saveRole(new Role(1454873L, "ROLE_ADMIN"));
			userService.saveRole(new Role(1454874L, "ROLE_SUPER_ADMIN"));
	
			userService.saveAppUser(new AppUser(14548741L, "Marlon Couto", "marloncori", "m0489921", new ArrayList<>()));
			userService.saveAppUser(new AppUser(1454872L, "Lazaro de Jesus", "poetaDeCDA", "mango7778#", new ArrayList<>()));
			userService.saveAppUser(new AppUser(1454873L, "Aniko Couto-Szalay", "szalay.ania", "COutoAniko07", new ArrayList<>()));
			userService.saveAppUser(new AppUser(1454874L, "Beniamin Couto-Szalay", "benjamin", "brazilHungary", new ArrayList<>()));

			userService.addRoleToUser("poetaDeCDA", "ROLE_MANAGER");
			userService.addRoleToUser("poetaDeCDA", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("szalay.ania", "ROLE_USER");
			userService.addRoleToUser("marloncori", "ROLE_ADMIN");
			userService.addRoleToUser("marloncori", "ROLE_USER");
			userService.addRoleToUser("benjamin", "ROLE_SUPER_ADMIN");
		};
	}
}
