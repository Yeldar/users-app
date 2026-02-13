package com.epam.nuralin.yeldar.write_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Getter
@Setter
public class CreateUserRequestDto implements Serializable {
    @NotNull(message = "Username must be not empty")
    @Length(min = 5, max = 100, message = "Length of username must be between 5 and 100")
    @Email(message = "Username must have email format")
    String username;

    @NotNull
    @Size(min = 8, max = 50, message = "Length of password must be between 8 and 50.")
    String password;

    @NotNull(message = "Username must be not empty")
    @Length(min = 3, max = 100, message = "Length of fullName must be between 3 and 100")
    String fullName;
}
