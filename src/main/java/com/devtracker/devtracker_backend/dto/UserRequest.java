package com.devtracker.devtracker_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {

    @NotBlank(message = "Name is required")

    private String name;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")

    private String email;

    @Size(min = 6, message = "Password must contain at least 6 characters")
    @NotBlank(message = " Password is required")
    private String password;

    @NotBlank(message = "Lastname is required")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    private String rol;
}
