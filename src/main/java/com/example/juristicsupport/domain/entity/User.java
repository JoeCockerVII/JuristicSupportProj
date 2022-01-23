package com.example.juristicsupport.domain.entity;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

/**
 * Internal data structure (User data)
 *
 * @author ilyin
 * @since 18.12.2021
 */

@Getter
@Setter
public class User {
    UUID id;
    String firstName;
    String lastName;
    String email;

}
