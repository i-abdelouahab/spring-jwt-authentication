package org.test.jwtauthentication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.test.jwtauthentication.entities.Role;
import org.test.jwtauthentication.services.UserService;

@SpringBootApplication
public class JwtAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
