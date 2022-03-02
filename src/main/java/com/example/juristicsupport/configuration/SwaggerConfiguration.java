package com.example.juristicsupport.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration file for Swagger
 *
 * @author ilyin
 * @since 01.03.2022
 */

@Configuration
@OpenAPIDefinition(info = @Info(title = "Test service",
        version = "1.0.0",
        description = "Do smth"))
public class SwaggerConfiguration {
}
