package com.mkcomp.CarRentalApp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Spring Boot servlet initializer
 */
public class ServletInitializer extends SpringBootServletInitializer {
	/**
	 * Default use of Spring application builder for application configuration
	 * @param application
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CarRentalAppApplication.class);
	}

}
