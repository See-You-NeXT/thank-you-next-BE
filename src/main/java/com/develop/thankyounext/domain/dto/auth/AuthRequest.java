package com.develop.thankyounext.domain.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

public class AuthRequest {
    public record LoginDTO(
            @NotBlank
            String email,
            @NotBlank
            String password
    ) {
    }

    public record SignUpDTO(
            @NotBlank
            @Size(max = 50)
            @Pattern(regexp = "^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\\.[A-Za-z0-9\\-]+$")
            String email,
            @NotBlank
            @Size(max = 50)
            String password,
            @NotBlank
            String paswordCheck,
            @NotBlank
            @Size(max = 10)
            String name,
            @NotNull
            @Size(min = 8, max = 8)
            String studentId
    ) {
    }
}
