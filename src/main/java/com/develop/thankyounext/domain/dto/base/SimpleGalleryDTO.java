package com.develop.thankyounext.domain.dto.base;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SimpleGalleryDTO {
    @NotBlank
    @Size(max = 50)
    private String title;
    @NotNull
    private ContentDTO image;
}
