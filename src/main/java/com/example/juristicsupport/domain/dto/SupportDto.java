package com.example.juristicsupport.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author ilyin
 * @since 03.01.2022
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
@Schema(description = "Support")
public class SupportDto {
    @Schema(description = "Support id",
            required = true,
            pattern = "*.",
            maxLength = 36,
            minLength = 36)
    UUID id;
    @Schema(description = "Code of support")
    Integer supportId;
    @Schema(description = "Type of support")
    String supportName;
    @Schema(description = "Proce of support")
    Integer supportPrice;
}
