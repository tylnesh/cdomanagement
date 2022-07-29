package com.lordsoftech.cdomanagment;

import com.lordsoftech.cdomanagment.model.AppUser;
import com.lordsoftech.cdomanagment.model.Role;
import com.lordsoftech.cdomanagment.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class CdomanagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdomanagmentApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(AppUserService userService) {
		return args -> {
			userService.saveRole(new Role("ROLE_USER"));
			userService.saveRole(new Role("ROLE_DESIGNER"));
			userService.saveRole(new Role("ROLE_DEALER"));
			userService.saveRole(new Role("ROLE_ADMIN"));
			userService.saveRole(new Role("ROLE_CUSTOMER"));

			userService.saveUser(new AppUser("michal@kohutek.eu","19091992"));
			userService.saveUser(new AppUser("test", "tester@gmail.com", "1234567890"));

			userService.addRoleToUser("michal@kohutek.eu", "ROLE_ADMIN");
			userService.addRoleToUser("michal@kohutek.eu", "ROLE_USER");
			userService.addRoleToUser("test", "ROLE_DEALER");
			userService.addRoleToUser("test", "ROLE_DESIGNER");
		};
	}

}


