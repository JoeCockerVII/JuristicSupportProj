package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.mapper.UserMapper;
import com.example.juristicsupport.domain.dto.UserCreateDto;
import com.example.juristicsupport.domain.dto.UserDto;
import com.example.juristicsupport.domain.dto.UserUpdateDto;
import com.example.juristicsupport.domain.exception.EntityNotFoundException;
import com.example.juristicsupport.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "User", description = "Controller to work with User Entity")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "User not found")
@ApiResponse(responseCode = "403", description = "Access Denied")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    /**
     * Get user by user id
     *
     * @param id user id
     * @return UserDto on JSON format
     */
    @Operation(description = "Find user by id")
    @ApiResponse(responseCode = "200", description = "User found")
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
    @Operation(description = "Add user")
    @ApiResponse(responseCode = "200", description = "User added")
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
    @Operation(description = "Update user by id")
    @ApiResponse(responseCode = "200", description = "User updated")
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
     *
     * @param id of user
     */
    @Operation(description = "Remove user by id")
    @ApiResponse(responseCode = "204", description = "User removed")
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN','CUSTOMER') || hasAnyAuthority('ROLE_ADMIN','ROLE_CUSTOMER')")
    public void delete(@PathVariable(name = "userId") UUID id) {
        userService.delete(id);
    }
}
