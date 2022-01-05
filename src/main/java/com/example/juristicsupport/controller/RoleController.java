package com.example.juristicsupport.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ilyin
 * @since 03.01.2022
 */
//path = http://localhost:8080/api/v1.0/users/{userId}/roles
@RestController
@RequestMapping(path = "users/{userId}/roles")
public class RoleController {
}
