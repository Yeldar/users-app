package com.epam.nuralin.yeldar.write_service.mapper;

import com.epam.nuralin.yeldar.write_service.dto.CreateUserRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.UpdateUserResponseDto;
import com.epam.nuralin.yeldar.write_service.entity.UserEntity;
import com.epam.nuralin.yeldar.write_service.util.HashUtils;
import lombok.SneakyThrows;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsersMapper {

    @Mapping(target = "passwordHash", source = "password")
    UserEntity fromCreateUserRequestDto(CreateUserRequestDto dto);

    UpdateUserResponseDto toUpdateUserResponseDto(UserEntity entity);

    @SneakyThrows
    default byte[] hashString(String string) {
        return HashUtils.sha256(string);
    }
}
