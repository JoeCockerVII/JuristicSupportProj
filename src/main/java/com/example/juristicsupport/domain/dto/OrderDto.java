package com.example.juristicsupport.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author ilyin
 * @since 18.01.2022
 */

@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class OrderDto {
    UUID id;

    UserDto user;
    JuristDto jurist;

    List<SupportDto> supports;
    Integer orderPrice;
}
