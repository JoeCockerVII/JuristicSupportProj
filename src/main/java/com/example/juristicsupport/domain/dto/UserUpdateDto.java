package com.example.juristicsupport.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author ilyin
 * @since 03.01.2022
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
@Schema(name = "UserCreate", description = "Update parameters of user")
public class UserUpdateDto {
    @Schema(description = "First name")
    String firstName;
    @Schema(description = "Last name")
    String lastName;
    @Schema(description = "Email")
    String email;
}