package com.epam.nuralin.yeldar.write_service.dto;

import java.time.OffsetDateTime;

public record UpdateUserResponseDto(
    Long id,
    String username,
    String fullName,
    OffsetDateTime created,
    OffsetDateTime updated
) {
}
