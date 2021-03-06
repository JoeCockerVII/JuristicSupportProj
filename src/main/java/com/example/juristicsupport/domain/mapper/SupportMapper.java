package com.example.juristicsupport.domain.mapper;

import com.example.juristicsupport.domain.dto.SupportCreateDto;
import com.example.juristicsupport.domain.dto.SupportDto;
import com.example.juristicsupport.domain.dto.SupportUpdateDto;
import com.example.juristicsupport.domain.entity.Support;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * Support data fields Mapper
 *
 * @author ilyin
 * @since 03.01.2022
 */
@Mapper
public interface SupportMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orders", ignore = true)
    Support fromCreateDto(SupportCreateDto source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orders", ignore = true)
    Support fromUpdateDto(SupportUpdateDto source);

    SupportDto toDto(Support source);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Support merge(@MappingTarget Support target, Support source);

}
