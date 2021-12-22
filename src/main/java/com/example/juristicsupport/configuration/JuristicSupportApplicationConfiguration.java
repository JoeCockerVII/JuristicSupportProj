package com.example.juristicsupport.configuration;

import com.example.juristicsupport.controller.UserController;
import com.example.juristicsupport.repository.Impl.UserRepositoryImpl;
import com.example.juristicsupport.repository.UserRepository;
import com.example.juristicsupport.service.UserService;
import com.example.juristicsupport.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Annotation configuration file for Application context
 *
 * @author ilyin
 * @since 20.12.2021
 */

@Configuration
@ComponentScan(value = "com.example.juristicsupport")
public class JuristicSupportApplicationConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


}
