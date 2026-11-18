package com.redStack.unirestPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UnirestPracticeApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(UnirestPracticeApplication.class, args);
		String[] beans = app.getBeanDefinitionNames();
		boolean check = false;
		String className = "profile";
		String found = "" ;
		for(String s : beans){
			System.out.println(s);
			if(s.equals(className))
			{
				check = true;
				found = s;

			}
		}
		System.out.println("================================================");
		System.out.println("is_Found: "+check);
		System.out.println("bean: "+found);



	}

}
