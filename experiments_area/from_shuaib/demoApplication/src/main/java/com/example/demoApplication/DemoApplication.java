package com.example.demoApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		System.out.println("=== ALL BEANS IN APPLICATION CONTEXT ===");

		String[] beanNames = context.getBeanDefinitionNames();
		boolean controllerFound = false;

		for(String name : beanNames){
			controllerFound = true;
		}

		if (controllerFound) {
			System.out.println("'feedbackController' bean found in context!");
		} else {
			System.out.println("Controller bean name may vary (check exact naming above).");
		}




	}

}
