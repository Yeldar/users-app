package com.epam.nuralin.yeldar.write_service.service;

import com.epam.nuralin.yeldar.write_service.dto.ChangePasswordRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.CreateUserRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.UpdateUserRequestDto;
import com.epam.nuralin.yeldar.write_service.dto.UpdateUserResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserCommandService {

    Long create(@Valid CreateUserRequestDto dto);

    UpdateUserResponseDto update(@NotNull Long id, @Valid UpdateUserRequestDto dto);

    void delete(@NotNull Long id);

    void changePassword(@NotNull Long id, @Valid ChangePasswordRequestDto dto);
}
