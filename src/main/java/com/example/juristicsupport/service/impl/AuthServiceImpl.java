package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.dto.security.LoginRequest;
import com.example.juristicsupport.domain.dto.security.LoginResponseDto;
import com.example.juristicsupport.domain.dto.security.SignUpRequest;
import com.example.juristicsupport.domain.entity.User;
import com.example.juristicsupport.repository.UserRepository;
import com.example.juristicsupport.service.AuthService;
import com.example.juristicsupport.service.TokenService;
import com.example.juristicsupport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service to LogIn and SignUp of Users
 *
 * @author ilyin
 * @since 24.02.2022
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    public LoginResponseDto login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return new LoginResponseDto(tokenService.generateToken(user), user.getId());
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public String signUp(SignUpRequest signUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setEmail(signUpRequest.getEmail());

        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setRole(signUpRequest.getRole());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userService.create(user);
        return tokenService.generateToken(user);
    }
}
