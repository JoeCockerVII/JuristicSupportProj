package com.example.juristicsupport.controller;

import com.example.juristicsupport.domain.dto.security.LoginRequest;
import com.example.juristicsupport.domain.dto.security.LoginResponseDto;
import com.example.juristicsupport.domain.dto.security.SignUpRequest;
import com.example.juristicsupport.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller of users authorization
 *
 * @author ilyin
 * @since 24.02.2022
 */
@RestController
@RequestMapping(path = "auth")
@RequiredArgsConstructor
@Tag(name = "Authorization", description = "Controller of users authorization")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "404", description = "User not found")
@ApiResponse(responseCode = "403", description = "Access Denied")
public class AuthController {

    private final AuthService authService;

    /**
     * Login of the User
     *
     * @param loginRequest
     * @return LoginResponseDto on JSON format
     */
    @Operation(description = "Login user")
    @ApiResponse(responseCode = "200", description = "Succesfully login")
    @PostMapping("login")
    public LoginResponseDto login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    /**
     * Signup of the User
     *
     * @param signUpRequest
     * @return String
     */
    @Operation(description = "Sign-up user")
    @ApiResponse(responseCode = "200", description = "Succesfully signup")
    @PostMapping("sign-up")
    public String signUp(@RequestBody SignUpRequest signUpRequest) {
        return authService.signUp(signUpRequest);
    }
}
