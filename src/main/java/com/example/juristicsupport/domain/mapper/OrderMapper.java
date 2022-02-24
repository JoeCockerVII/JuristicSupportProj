package com.example.juristicsupport.domain.mapper;

import com.example.juristicsupport.domain.dto.OrderCreateDto;
import com.example.juristicsupport.domain.dto.OrderDto;
import com.example.juristicsupport.domain.entity.Order;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * Order data fields Mapper
 *
 * @author ilyin
 * @since 20.01.2022
 */
@Mapper
public interface OrderMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "jurist", ignore = true)
    @Mapping(target = "orderPrice", ignore = true)
    @Mapping(target = "supports", ignore = true)
    Order fromCreateDto(OrderCreateDto source);

    OrderDto toDto(Order source);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Order merge(@MappingTarget Order target, Order source);

}
