package com.example.juristicsupport.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author ilyin
 * @since 18.01.2022
 */
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
@Schema(name = "SupportCreate", description = "Create parameters of support")
public class SupportCreateDto {
    @Schema(description = "Code of support")
    Integer supportId;
    @Schema(description = "Type of support")
    String supportName;
    @Schema(description = "Proce of support")
    Integer supportPrice;
}
