package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.mapper.UserMapper;
import com.example.juristicsupport.domain.dto.UserCreateDto;
import com.example.juristicsupport.domain.dto.UserDto;
import com.example.juristicsupport.domain.dto.UserUpdateDto;
import com.example.juristicsupport.domain.exception.EntityNotFoundException;
import com.example.juristicsupport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * Controller to work with User Entity
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

    /**
     * Get user by user id
     *
     * @param id user id
     * @return UserDto on JSON format
     */

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') || hasAuthority('ROLE_ADMIN')")
    public UserDto get(@PathVariable(name = "userId") UUID id) {
        return Optional.of(id)
                .map(userService::get)
                .map(userMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(id, "User"));
    }

    /**
     * Add new user
     *
     * @param createDto UserCreateDto
     * @return UserDto on JSON format
     */
    @PostMapping
    @PostAuthorize("hasRole('ADMIN') || hasAuthority('ROLE_ADMIN')")
    public UserDto create(@RequestBody UserCreateDto createDto) {
        return Optional.ofNullable(createDto)
                .map(userMapper::fromCreateDto)
                .map(userService::create)
                .map(userMapper::toDto)
                .orElseThrow();
    }

    /**
     * Update user by id
     *
     * @param id        of user
     * @param updateDto UserUpdateDto
     * @return UserDto on JSON format
     */
    @PatchMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN','CUSTOMER') || hasAnyAuthority('ROLE_ADMIN','ROLE_CUSTOMER')")
    public UserDto update(@PathVariable(name = "userId") UUID id, @RequestBody UserUpdateDto updateDto) {
        return Optional.ofNullable(updateDto)
                .map(userMapper::fromUpdateDto)
                .map(toUpdate -> userService.update(id, toUpdate))
                .map(userMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(id, "User"));
    }

    /**
     * Delete user
     * @param id of user
     */
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN','CUSTOMER') || hasAnyAuthority('ROLE_ADMIN','ROLE_CUSTOMER')")
    public void delete(@PathVariable(name = "userId") UUID id) {
        userService.delete(id);
    }
}
