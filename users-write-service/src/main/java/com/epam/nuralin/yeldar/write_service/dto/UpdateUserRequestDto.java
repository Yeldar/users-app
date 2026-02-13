package com.epam.nuralin.yeldar.write_service.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record UpdateUserRequestDto(

    @NotNull(message = "Username must be not empty")
    @Length(min = 3, max = 100, message = "Length of fullName must be between 3 and 100")
    String fullName
) {
}
