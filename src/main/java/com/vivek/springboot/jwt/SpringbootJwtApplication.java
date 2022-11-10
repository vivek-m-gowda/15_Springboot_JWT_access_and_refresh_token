package com.vivek.springboot.jwt;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vivek.springboot.jwt.domain.Role;
import com.vivek.springboot.jwt.domain.User;
import com.vivek.springboot.jwt.service.UserService;

@SpringBootApplication
public class SpringbootJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJwtApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new User(null, "ram", "ramm", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "nohih", "nohiii", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "vinay", "vinayas", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "vivek", "mvivekraj", "1234", new ArrayList<>()));
			
			userService.addRoleToUser("ramm", "ROLE_USER");
			userService.addRoleToUser("nohiii", "ROLE_MANAGER");
			userService.addRoleToUser("vinayas", "ROLE_ADMIN");
			userService.addRoleToUser("mvivekraj", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("mvivekraj", "ROLE_USER");
			userService.addRoleToUser("mvivekraj", "ROLE_MANAGER");
			userService.addRoleToUser("mvivekraj", "ROLE_ADMIN");
		};
	}
	
}
