package com.develop.thankyounext.domain.dto.base;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ContentDTO {
    @NotNull
    private String contentUrl;
}
