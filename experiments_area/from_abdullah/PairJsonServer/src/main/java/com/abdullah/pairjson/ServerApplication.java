package com.abdullah.pairjson;

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

        for (int i = 0; i < beanNames.length; i++) {
            System.out.println(beanNames[i]);
            if (beanNames[i].equals("profileController")) {
                found = true;
            }
        }

        System.out.println("Profile controller bean found: " + found);
    }
}
