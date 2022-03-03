package com.example.juristicsupport.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author ilyin
 * @since 18.01.2022
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
@Schema(name = "OrderCreate", description = "Create order")
public class OrderCreateDto {
    @Schema(description = "Types of dupports needs in Order")
    List<Integer> supportsId;
}
