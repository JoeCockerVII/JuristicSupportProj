package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.entity.User;
import com.example.juristicsupport.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.UUID;

/**
 * Controller to work with User
 *
 * @author ilyin
 * @since 18.12.2021
 */

@Controller
@RequiredArgsConstructor
public class UserController {

    private final ObjectMapper objectMapper;
    private final UserService userService;

    private UserService setterUserService; //
    /*
    @Autowired
    public UserController(ObjectMapper objectMapper, UserService userService) {
        this.objectMapper = objectMapper;
        this.userService = userService;
    }*/

    @SneakyThrows
    public String get(String id) {
        return objectMapper.writeValueAsString(userService.get(UUID.fromString(id)));
    }

    @SneakyThrows
    public String create(String userJson) {
        User user = objectMapper.readValue(userJson, User.class);
        User created = userService.create(user);
        return objectMapper.writeValueAsString(created);
    }

    @SneakyThrows
    public String update(String id, String userJson) {
        User user = objectMapper.readValue(userJson, User.class);
        User created = userService.update(UUID.fromString(id), user);
        return objectMapper.writeValueAsString(created);
    }

    public void delete(String id) {
        userService.delete(UUID.fromString(id));
    }

    @Autowired
    public void setSetterUserService(UserService setterUserService) {
        this.setterUserService = setterUserService;
    }
}
