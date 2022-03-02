package com.example.juristicsupport.domain.dto.security;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author ilyin
 * @since 24.02.2022
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
@Schema(name = "Login", description = "User login request")
public class LoginRequest {
    @Schema(description = "Email")
    String email;
    @Schema(description = "Password")
    String password;
}
