package com.mkcomp.CarRentalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.mkcomp.CarRentalApp.controller",
		"com.mkcomp.CarRentalApp.model",
		"com.mkcomp.CarRentalApp.repository",
		"com.mkcomp.CarRentalApp.service"
})
public class CarRentalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalAppApplication.class, args);
	}

}
