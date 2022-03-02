package com.example.juristicsupport.domain.dto;

/**
 * @author ilyin
 * @since 11.02.2022
 */

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
@Schema(description = "Jurist")
public class JuristDto {
    @Schema(description = "Jurist id",
            required = true,
            pattern = "*.",
            maxLength = 36,
            minLength = 36)
    UUID id;
    @Schema(description = "First name")
    String firstName;
    @Schema(description = "Last name")
    String lastName;
    @Schema(description = "Work expirience")
    Integer workExperience;
}
