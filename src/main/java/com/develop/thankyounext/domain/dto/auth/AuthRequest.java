package com.develop.thankyounext.domain.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AuthRequest {

    public record Login(
            @NotBlank
            String email,
            @NotBlank
            String password
    ) {
    }

    public record SignUp(
            @NotBlank
            @Size(max = 50)
            @Pattern(regexp = "^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\\.[A-Za-z0-9\\-]+$")
            String email,
            @NotBlank
            @Size(max = 50)
            String password,
            @NotBlank
            String passwordCheck,
            @NotBlank
            @Size(max = 10)
            String name,
            @NotNull
            @Size(min = 8, max = 8)
            String studentId
    ) {
    }
}
