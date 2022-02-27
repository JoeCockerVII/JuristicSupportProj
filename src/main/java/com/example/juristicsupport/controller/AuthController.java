package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.dto.security.LoginRequest;
import com.example.juristicsupport.domain.dto.security.LoginResponseDto;
import com.example.juristicsupport.domain.dto.security.SignUpRequest;
import com.example.juristicsupport.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ilyin
 * @since 24.02.2022
 */
@RestController
@RequestMapping(path = "auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public LoginResponseDto login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("sign-up")
    public String signUp(@RequestBody SignUpRequest signUpRequest) {
        return authService.signUp(signUpRequest);
    }
}
