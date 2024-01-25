package com.develop.thankyounext.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LoginDTO {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
