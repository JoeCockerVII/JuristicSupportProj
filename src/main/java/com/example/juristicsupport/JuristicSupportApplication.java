package com.example.juristicsupport;

import com.example.juristicsupport.configuration.JuristicSupportApplicationConfiguration;
import com.example.juristicsupport.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JuristicSupportApplication {

    public static void main(String[] args) {

        String input = "{\"firstName\":\"firstName\", \"email\":\"email\", \"lastName\":\"lastName\"}";

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JuristicSupportApplicationConfiguration.class);
        UserController userController = applicationContext.getBean("userController", UserController.class);

        userController.create(input);
        System.out.println(userController.get("42c02419-4b95-45be-8646-7bb940a2ed77"));

    }

}
