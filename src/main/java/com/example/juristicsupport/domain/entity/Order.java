package com.example.juristicsupport.domain.entity;

import com.example.juristicsupport.domain.dto.OrderCreateDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/**
 * Internal data structure(User Order entity)
 *
 * @author ilyin
 * @since 14.01.2022
 */

@Getter
@Setter
public class Order {
    UUID orderId;
    UUID userId;
    List<Integer> supportsId;
    List<Support> supports;
    Jurist jurist;
    Integer orderPrice;
}
