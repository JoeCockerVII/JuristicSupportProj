package com.example.juristicsupport.domain.entity;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

/**
 * Internal data structure (User data)
 *
 * @author ilyin
 * @since 18.12.2021
 */

@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class User {
    @With
    UUID id;
    String firstName;
    String lastName;
    String email;
    String supportId;
}
