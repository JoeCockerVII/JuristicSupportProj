package com.example.juristicsupport.domain.dto.security;

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
public class LoginResponseDto {
    String token;
    UUID userId;
}