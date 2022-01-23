package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.mapper.UserMapper;
import com.example.juristicsupport.domain.dto.UserCreateDto;
import com.example.juristicsupport.domain.dto.UserDto;
import com.example.juristicsupport.domain.dto.UserUpdateDto;
import com.example.juristicsupport.domain.exception.UserNotFoundException;
import com.example.juristicsupport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * Controller to work with User
 *
 * @author ilyin
 * @since 18.12.2021
 */

@RestController
//path = http://localhost:8080/api/v1.0/users
@RequestMapping(path = "users")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserDto get(@PathVariable(name = "userId") UUID id) {
        return Optional.of(id)
                .map(userService::get)
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping
    public UserDto create(@RequestBody UserCreateDto createDto) {
        return Optional.ofNullable(createDto)
                .map(userMapper::fromCreateDto)
                .map(userService::create)
                .map(userMapper::toDto)
                .orElseThrow();
    }

    @PatchMapping("/{userId}")
    public UserDto update(@PathVariable(name = "userId") UUID id, @RequestBody UserUpdateDto updateDto) {
        return Optional.ofNullable(updateDto)
                .map(userMapper::fromUpdateDto)
                .map(toUpdate -> userService.update(id, toUpdate))
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable(name = "userId") UUID id) {
        userService.delete(id);
    }


}
