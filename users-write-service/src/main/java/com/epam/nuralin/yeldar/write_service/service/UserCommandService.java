package com.epam.nuralin.yeldar.write_service.service;

import com.epam.nuralin.yeldar.write_service.dto.ChangePasswordRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.CreateUserRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.UpdateUserRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.UpdateUserResponseDto;

public interface UserCommandService {

    Long create(CreateUserRequestDto dto);

    UpdateUserResponseDto update(Long id, UpdateUserRequestDto dto);

    void delete(Long id);

    void changePassword(Long id, ChangePasswordRequestDto dto);
}
