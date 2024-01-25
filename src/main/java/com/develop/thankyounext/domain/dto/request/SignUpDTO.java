package com.develop.thankyounext.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignUpDTO {
    @NotBlank
    @Size(max = 50)
    @Pattern(regexp = "^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\\.[A-Za-z0-9\\-]+$")
    private String email;
    @NotBlank
    @Size(max = 50)
    private String password;
    @NotNull
    private String paswordCheck;
    @NotBlank
    @Size(max = 10)
    private String name;
    @NotNull
    @Size(min = 8, max = 8)
    private String studentId;
}
