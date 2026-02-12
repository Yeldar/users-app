package com.epam.nuralin.yeldar.write_service.dto;

public record ChangePasswordRequestDto(
    String currentPassword,
    String newPassword
) {
}
