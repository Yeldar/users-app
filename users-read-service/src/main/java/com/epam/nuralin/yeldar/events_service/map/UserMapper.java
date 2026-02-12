package com.epam.nuralin.yeldar.events_service.map;

import com.epam.nuralin.yeldar.events_service.dto.UserDto;
import com.epam.nuralin.yeldar.events_service.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDto toDto(UserEntity entity);

    UserEntity fromDto(UserDto dto);
}
