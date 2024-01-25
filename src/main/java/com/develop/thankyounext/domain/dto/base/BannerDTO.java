package com.develop.thankyounext.domain.dto.base;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class BannerDTO {
    @NotNull
    @Size(max = 50)
    private String title;
    @NotNull
    @Size(max = 150)
    private String description;
    private String url;
}
