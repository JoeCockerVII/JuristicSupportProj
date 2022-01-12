package com.example.juristicsupport.domain.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author ilyin
 * @since 08.01.2022
 */
@ResponseStatus(value = NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(UUID id) {
        super("User not found: id=" + id);
    }
}

