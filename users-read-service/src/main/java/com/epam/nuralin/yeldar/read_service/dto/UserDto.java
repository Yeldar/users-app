package com.epam.nuralin.yeldar.read_service.dto;

import java.time.OffsetDateTime;

public record UserDto(
    Long id,
    String username,
    String fullName,
    boolean active,
    OffsetDateTime created,
    OffsetDateTime updated
) {
}
