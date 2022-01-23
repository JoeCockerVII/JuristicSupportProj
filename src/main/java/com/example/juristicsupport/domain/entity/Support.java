package com.example.juristicsupport.domain.entity;

import lombok.*;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

/**
 * Internal data structure(Support entity)
 *
 * @author ilyin
 * @since 14.01.2022
 */

@AllArgsConstructor
@Getter
@Setter(value = PRIVATE)
public class Support {
    Integer SupportId;
    String SupportName;
    Integer SupportPrice;
}
