package com.lordsoftech.cdomanagment;

import com.lordsoftech.cdomanagment.model.AppUser;
import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.model.Printer;
import com.lordsoftech.cdomanagment.model.Role;
import com.lordsoftech.cdomanagment.service.AppUserService;
import com.lordsoftech.cdomanagment.service.DealerService;
import com.lordsoftech.cdomanagment.service.PrinterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


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
	CommandLineRunner run(AppUserService userService, DealerService dealerService, PrinterService printerService) {
		return args -> {
			userService.saveRole(new Role("ROLE_USER"));
			userService.saveRole(new Role("ROLE_DESIGNER"));
			userService.saveRole(new Role("ROLE_DEALER"));
			userService.saveRole(new Role("ROLE_ADMIN"));
			userService.saveRole(new Role("ROLE_CUSTOMER"));

			userService.saveUser(new AppUser("it@moto-stylemx.com","msmx"));
			userService.saveUser(new AppUser("test", "tester@gmail.com", "1234567890"));

			userService.addRoleToUser("it@moto-stylemx.com", "ROLE_ADMIN");
			userService.addRoleToUser("it@moto-stylemx.com", "ROLE_USER");
			userService.addRoleToUser("test", "ROLE_DEALER");
			userService.addRoleToUser("test", "ROLE_DESIGNER");

			dealerService.saveDealer(new Dealer("Testing 1","t1"));
			dealerService.saveDealer(new Dealer("Testing 2","t2"));
			dealerService.saveDealer(new Dealer("Testing 3","t3"));
			dealerService.saveDealer(new Dealer("Testing 4","t4"));
			dealerService.saveDealer(new Dealer("Testing 5","t5"));
			dealerService.saveDealer(new Dealer("Testing 6","t6"));
			dealerService.saveDealer(new Dealer("Testing 7","t7"));
			dealerService.saveDealer(new Dealer("Testing 8","t8"));
			dealerService.saveDealer(new Dealer("Testing 9","t9"));
			dealerService.saveDealer(new Dealer("Testing 10", "t10"));
			dealerService.saveDealer(new Dealer("Testing 11", "t11"));
			dealerService.saveDealer(new Dealer("Testing 12", "t12"));
			dealerService.saveDealer(new Dealer("Testing 13", "t13"));
			dealerService.saveDealer(new Dealer("Testing 14", "t14"));
			dealerService.saveDealer(new Dealer("Testing 15", "t15"));
			dealerService.saveDealer(new Dealer("Testing 16", "t16"));
			dealerService.saveDealer(new Dealer("Testing 17", "t17"));
			dealerService.saveDealer(new Dealer("Testing 18", "t18"));
			dealerService.saveDealer(new Dealer("Testing 19", "t19"));
			dealerService.saveDealer(new Dealer("Testing 20", "t20"));
			dealerService.saveDealer(new Dealer("Testing 21", "t21"));
			dealerService.saveDealer(new Dealer("Testing 22", "t22"));
			dealerService.saveDealer(new Dealer("Testing 23", "t23"));


			printerService.savePrinter(new Printer("NEW"));
			printerService.savePrinter(new Printer("OLD"));
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}

}


