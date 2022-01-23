package com.example.juristicsupport.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static lombok.AccessLevel.PRIVATE;

/**
 * Internal data structure(Jurist entity)
 *
 * @author ilyin
 * @since 22.01.2022
 */

@AllArgsConstructor
@Getter
@Setter(value = PRIVATE)
public class Jurist {
    String firstName;
    String lastName;
    Integer workExperience;
}
