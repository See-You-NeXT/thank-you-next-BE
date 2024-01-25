package com.develop.thankyounext.domain.dto.base;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class TagDTO {
    @NotBlank
    @Size(max = 20)
    private String name;
}
