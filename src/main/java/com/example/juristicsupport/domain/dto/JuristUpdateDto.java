package com.example.juristicsupport.domain.dto;

/**
 * @author ilyin
 * @since 11.02.2022
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
public class JuristUpdateDto {
    String firstName;
    String lastName;
    Integer workExperience;
}
