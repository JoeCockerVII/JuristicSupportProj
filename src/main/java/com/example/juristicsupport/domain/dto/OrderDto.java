package com.example.juristicsupport.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Order")
public class OrderDto {
    @Schema(description = "Support id",
            required = true,
            pattern = "*.",
            maxLength = 36,
            minLength = 36)
    UUID id;
    @Schema(description = "User")
    UserDto user;
    @Schema(description = "Jurist of Order")
    JuristDto jurist;
    @Schema(description = "Supports of Order")
    List<SupportDto> supports;
    @Schema(description = "Total price of Order")
    Integer orderPrice;
}
