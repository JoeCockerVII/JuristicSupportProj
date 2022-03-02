package com.example.juristicsupport.domain.dto.security;

import com.example.juristicsupport.domain.dto.UserCreateDto;
import com.example.juristicsupport.domain.entity.Role;
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
@Schema(name = "Signup", description = "User signup request")
public class SignUpRequest {
    @Schema(description = "First name")
    String firstName;
    @Schema(description = "Last name")
    String lastName;
    @Schema(description = "Email")
    String email;
    @Schema(description = "Password")
    String password;
    @Schema(description = "Role of user")
    Role role;
}
