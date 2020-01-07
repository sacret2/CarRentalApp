package com.mkcomp.CarRentalApp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Class enabling setting various application properties;
 * used to start the servlet.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Default use - no changes in default application configuration
	 * @param application
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CarRentalAppApplication.class);
	}

}
