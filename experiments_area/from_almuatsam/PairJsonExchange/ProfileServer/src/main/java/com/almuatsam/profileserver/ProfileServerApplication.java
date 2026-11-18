package com.almuatsam.profileserver;
import com.almuatsam.profileserver.controller.ProfileController;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileServerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProfileServerApplication.class, args);

		String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}

		String[] controllerBeans = context.getBeanNamesForType(ProfileController.class);
		if (controllerBeans.length > 0) {
			System.out.println("ProfileController bean found: " + controllerBeans[0]);
		} else {
			System.out.println("ProfileController bean NOT found");
		}
	}

}
