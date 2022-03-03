package com.example.juristicsupport.domain.dto;

import com.example.juristicsupport.domain.entity.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author ilyin
 * @since 03.01.2022
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
@Schema(description = "User")
public class UserDto {
    @Schema(description = "User id",
            required = true,
            pattern = "*.",
            maxLength = 36,
            minLength = 36)
    UUID id;
    @Schema(description = "First name")
    String firstName;
    @Schema(description = "Last name")
    String lastName;
    @Schema(description = "Email")
    String email;
    @Schema(description = "Role of user")
    Role role;
}
