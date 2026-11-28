package com.redDesck.desk.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// The application context holds all beans and gives access to them
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DeskApiApplication {

	public static void main(String[] args) {
		// Keep the context that run(...) returns
		ConfigurableApplicationContext context = SpringApplication.run(DeskApiApplication.class, args);

		// Print the names of all beans Spring created
		String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}

		// Confirm Spring registered my #522 controller as a bean
		boolean found = context.containsBean("profileController");

		if (found) {
			System.out.println("profileController found!");
		} else {
			System.out.println("profileController not found.");
		}

		// Confirm Spring registered the new feedback controller as a bean
		boolean feedbackFound = context.containsBean("feedbackController");

		if (feedbackFound) {
			System.out.println("feedbackController found!");
		} else {
			System.out.println("feedbackController not found.");
		}
	}
}