package com.example.juristicsupport;

import com.example.juristicsupport.configuration.JuristicSupportApplicationConfiguration;
import com.example.juristicsupport.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JuristicSupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuristicSupportApplication.class);
    }

}
