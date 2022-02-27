package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.dto.security.LoginRequest;
import com.example.juristicsupport.domain.dto.security.LoginResponseDto;
import com.example.juristicsupport.domain.dto.security.SignUpRequest;

/**
 * @author ilyin
 * @since 26.02.2022
 */
public interface AuthService {
    LoginResponseDto login(LoginRequest loginRequest);

    String signUp(SignUpRequest signUpRequest);
}
