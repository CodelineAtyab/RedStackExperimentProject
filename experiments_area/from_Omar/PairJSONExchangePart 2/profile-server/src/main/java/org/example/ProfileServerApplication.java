package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

@SpringBootApplication
public class ProfileServerApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProfileServerApplication.class, args);
        System.out.println("========================================");
        System.out.println("SPRING BEANS LOADED IN APPLICATION CONTEXT:");
        System.out.println("========================================");

        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        boolean controllerFound = false;
        String targetBeanName = "profileController";

        for (String beanName : beanNames) {
            System.out.println(" - "+ beanName);

            if (beanName.equals(targetBeanName)) {
                controllerFound = true;
            }
        }

        System.out.println("========================================");
        if(controllerFound){
            System.out.println("CONFIRMATION: Successfully found your bean ('" + targetBeanName + "') in the context!");

        } else {
            System.out.println("WARNING: Could not find '" + targetBeanName + "'. Check your component scanning or naming.");
        }
        System.out.println("========================================");
        }
    }
