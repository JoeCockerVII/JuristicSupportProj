package com.example.juristicsupport.domain.mapper;

import com.example.juristicsupport.domain.dto.JuristCreateDto;
import com.example.juristicsupport.domain.dto.JuristDto;
import com.example.juristicsupport.domain.dto.JuristUpdateDto;
import com.example.juristicsupport.domain.entity.Jurist;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * jurist data fields Mapper
 *
 * @author ilyin
 * @since 03.01.2022
 */
@Mapper
public interface JuristMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "busyStatus", ignore = true)
    Jurist fromCreateDto(JuristCreateDto source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "busyStatus", ignore = true)
    Jurist fromUpdateDto(JuristUpdateDto source);

    JuristDto toDto(Jurist source);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Jurist merge(@MappingTarget Jurist target, Jurist source);

}
