package com.example.juristicsupport.domain.dto;

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
public class UserCreateDto {
    String firstName;
    String lastName;
    String email;
    String supportId;
}
