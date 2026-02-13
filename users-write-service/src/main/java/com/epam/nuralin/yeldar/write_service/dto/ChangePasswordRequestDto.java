package com.epam.nuralin.yeldar.write_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ChangePasswordRequestDto(

    String currentPassword,

    @NotNull
    @Size(min = 8, max = 50, message = "Length of password must be between 8 and 50.")
    String newPassword
) {
}
