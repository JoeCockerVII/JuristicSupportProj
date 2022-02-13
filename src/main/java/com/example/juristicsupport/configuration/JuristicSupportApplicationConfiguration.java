package com.example.juristicsupport.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Annotation configuration file for Application context
 *
 * @author ilyin
 * @since 20.12.2021
 */

@Configuration
//@ComponentScan(value = "com.example.juristicsupport")
@EnableScheduling
public class JuristicSupportApplicationConfiguration {

}
