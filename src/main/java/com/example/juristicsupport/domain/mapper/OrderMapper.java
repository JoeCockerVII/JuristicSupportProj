package com.example.juristicsupport.domain.mapper;

import com.example.juristicsupport.domain.dto.OrderCreateDto;
import com.example.juristicsupport.domain.dto.OrderDto;
import com.example.juristicsupport.domain.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

/**
 * Order data fields Mapper
 *
 * @author ilyin
 * @since 20.01.2022
 */

@Mapper
public interface OrderMapper {

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "orderId", ignore = true)
    @Mapping(target = "jurist", ignore = true)
    @Mapping(target = "orderPrice", ignore = true)
    @Mapping(target = "supports", ignore = true)
    Order fromCreateDto(UUID userId, OrderCreateDto source);

    OrderDto toDto(Order source);

}
