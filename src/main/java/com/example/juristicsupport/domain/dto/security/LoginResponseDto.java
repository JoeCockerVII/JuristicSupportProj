package com.example.juristicsupport.domain.dto.security;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author ilyin
 * @since 24.02.2022
 */
@Value
@Setter
@Builder
@Jacksonized
@RequiredArgsConstructor
@Schema(name = "LoginResponse", description = "User login response")
public class LoginResponseDto {
    @Schema(description = "Token")
    String token;
    @Schema(description = "User id",
            required = true,
            pattern = "*.",
            maxLength = 36,
            minLength = 36)
    UUID userId;
}