package com.epam.nuralin.yeldar.events_service.dto;

import java.time.OffsetDateTime;

public record UserDto(
    Long id,
    String username,
    String fullName,
    boolean isActive,
    OffsetDateTime created,
    OffsetDateTime updated
) {
}
