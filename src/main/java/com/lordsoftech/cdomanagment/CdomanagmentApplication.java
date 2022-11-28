package com.lordsoftech.cdomanagment;

import com.lordsoftech.cdomanagment.model.*;
import com.lordsoftech.cdomanagment.service.*;
import net.bytebuddy.utility.RandomString;
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
	CommandLineRunner run(AppUserService userService, DesignService designService, DealerService dealerService, PrinterService printerService, ModelService modelService, PaymentService paymentService, StatusService statusService) {
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


			for (int i = 0; i< 25; i++) {
				dealerService.saveDealer(new Dealer(RandomString.make(8), "d" + Integer.toString(i)));
				short year = (short) (1990 + (short) (Math.random() * 30));
				designService.saveDesign(new Design(RandomString.make(4), "/files/images"+RandomString.make(4)+".png"));
				modelService.saveModel(new Model(RandomString.make(4), RandomString.make(4), year, (short) (year + i)));
			}
			printerService.savePrinter(new Printer("NEW"));
			printerService.savePrinter(new Printer("OLD"));

			paymentService.savePayment(new Payment("PayPal"));
			paymentService.savePayment(new Payment("Credit Card"));
			paymentService.savePayment(new Payment("Bank Transfer"));
			paymentService.savePayment(new Payment("Firstborn son"));

			statusService.saveStatus(new Status("None", "#FFFFFF"));
			statusService.saveStatus(new Status("Approved for production", "#00FFFF"));
			statusService.saveStatus(new Status("EPS DONE", "#FFFF00"));
			statusService.saveStatus(new Status("Printed", "#00FF00"));
			statusService.saveStatus(new Status("Package complete", "#d3d3d3"));
			statusService.saveStatus(new Status("Archived", "#FFFFFF"));
			statusService.saveStatus(new Status("Hold", "#FF0000"));
			statusService.saveStatus(new Status("Upstairs", "#0000FF"));

			designService.linkDesignModel(designService.getDesign((long) 1), modelService.getModel((long) 1));


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


