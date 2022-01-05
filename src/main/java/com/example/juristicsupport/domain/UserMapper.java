package com.example.juristicsupport.domain;

import com.example.juristicsupport.domain.dto.UserCreateDto;
import com.example.juristicsupport.domain.dto.UserDto;
import com.example.juristicsupport.domain.dto.UserUpdateDto;
import com.example.juristicsupport.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
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
}
