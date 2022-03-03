package com.example.juristicsupport.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration file for Swagger
 *
 * @author ilyin
 * @since 01.03.2022
 */

/*
 * http://localhost:8081/api/v1.0/swagger-ui/index.html?configUrl=/api/v1.0/v3/api-docs/swagger-config
 */
@Configuration
@EnableSwagger2
@OpenAPIDefinition(info = @Info(title = "Juristic Support",
        version = "1.0.0",
        description = "Documentation of Juristic Support Application"))
public class SwaggerConfiguration {

}
