package com.profileServer.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(ServerApplication.class, args);

        String[] beanNames = context.getBeanDefinitionNames();

        boolean found = false;

        for (String beanName : beanNames) {

            System.out.println(beanName);

            if (beanName.equals("profileController")) {
                found = true;
            }
        }

        System.out.println("ProfileController found: " + found);
    }
}
