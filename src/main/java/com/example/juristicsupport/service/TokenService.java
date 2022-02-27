package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.User;

/**
 * Service Interface to Generate and Validate Token
 *
 * @author ilyin
 * @since 24.02.2022
 */
public interface TokenService {
    String generateToken(User user);

    String extractUsernameAndValidate(String token);
}
