package com.develop.thankyounext.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateCommentDTO {
    @NotBlank
    @Size(max = 500)
    private String content;
}
