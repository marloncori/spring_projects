package pl.millenium.employee_register.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://locahost:4200")
                    .allowedHeaders("Origin", "Access-Control-Allow-Origin", "Control-Type",
                            "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                            "Access-Control-Request-Method", "Access-Control-Request-Headers")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowCredentials(true).maxAge(3600);
        }
}
