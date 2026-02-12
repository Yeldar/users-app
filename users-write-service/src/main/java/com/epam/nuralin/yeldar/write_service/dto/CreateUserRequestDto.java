package com.epam.nuralin.yeldar.write_service.dto;

public record CreateUserRequestDto(
    String username,
    String password,
    String fullName
) {
}
