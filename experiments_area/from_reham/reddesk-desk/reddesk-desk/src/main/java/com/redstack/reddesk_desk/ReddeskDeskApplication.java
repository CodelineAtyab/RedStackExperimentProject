package com.redstack.reddesk_desk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReddeskDeskApplication {

	public static void main(String[] args) {

		//Store the Application Context in a variable
		ConfigurableApplicationContext context =
				SpringApplication.run(ReddeskDeskApplication.class, args); //Starts the springboot application

		//Store the names in an Array and print them using for loop
		String [] beanNames = context.getBeanDefinitionNames();
		for (int i =0 ;i< beanNames.length ;i++ ) {
			System.out.println(beanNames[i]);
		}

	}

}
