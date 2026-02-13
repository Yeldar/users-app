package com.epam.nuralin.yeldar.read_service.dto;

import java.time.OffsetDateTime;

public record UserDto(
    Long id,
    String username,
    String fullName,
    OffsetDateTime created,
    OffsetDateTime updated
) {
}
