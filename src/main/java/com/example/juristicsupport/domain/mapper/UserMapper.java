package com.example.juristicsupport.domain.mapper;

import com.example.juristicsupport.domain.dto.UserCreateDto;
import com.example.juristicsupport.domain.dto.UserDto;
import com.example.juristicsupport.domain.dto.UserUpdateDto;
import com.example.juristicsupport.domain.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * User data fields Mapper
 *
 * @author ilyin
 * @since 03.01.2022
 */
@Mapper
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User fromCreateDto(UserCreateDto source);

    @Mapping(target = "id", ignore = true)
    User fromUpdateDto(UserUpdateDto source);

    UserDto toDto(User source);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    User merge(@MappingTarget User target, User source);
}
