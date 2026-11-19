package com.redstack.ProfileServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProfileServerApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ProfileServerApplication.class, args);

		String[] beans = context.getBeanDefinitionNames();

		boolean found = false;

		for (String bean : beans) {
			System.out.println(bean);

			if (bean.equals("profileController")) {
				found = true;
			}
		}

		System.out.println("ProfileController found: " + found);
	}
}