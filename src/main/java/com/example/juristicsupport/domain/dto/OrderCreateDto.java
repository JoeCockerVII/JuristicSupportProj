package com.example.juristicsupport.domain.dto;

import com.example.juristicsupport.domain.entity.Support;
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
public class OrderCreateDto {
    List<Integer> supportsId;
}
