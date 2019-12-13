package com.mkcomp.CarRentalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main class of a program contatining method public static void main(String[] args), which is an entry point of an application.
 */
@SpringBootApplication
@ComponentScan(basePackages = {
		"com.mkcomp.CarRentalApp.controller",
		"com.mkcomp.CarRentalApp.model",
		"com.mkcomp.CarRentalApp.repository",
		"com.mkcomp.CarRentalApp.service"
})
public class CarRentalAppApplication {

	/**
	 * Runs Spring context
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CarRentalAppApplication.class, args);
	}

}
