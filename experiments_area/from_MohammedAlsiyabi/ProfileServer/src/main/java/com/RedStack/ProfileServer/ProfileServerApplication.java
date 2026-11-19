package com.RedStack.ProfileServer;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProfileServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(ProfileServerApplication.class, args);


		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		System.out.println("===== Beans in the application context (" + beanNames.length + ") =====");
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}


		if (context.containsBean("profileController")) {
			System.out.println(">>> FOUND my #522 class as a bean: profileController");
		} else {
			System.out.println(">>> NOT FOUND: profileController");
		}
		if (context.containsBean("feedbackController")) {
			System.out.println(">>> FOUND my Part 2 class as a bean: feedbackController");
		}
	}
}