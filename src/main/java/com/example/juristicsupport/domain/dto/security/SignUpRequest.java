package com.example.juristicsupport.domain.dto.security;

import com.example.juristicsupport.domain.dto.UserCreateDto;
import com.example.juristicsupport.domain.entity.Role;
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
public class SignUpRequest {
    //    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    Role role;
}
