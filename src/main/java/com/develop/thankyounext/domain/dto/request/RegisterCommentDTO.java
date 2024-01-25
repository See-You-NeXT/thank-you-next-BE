package com.develop.thankyounext.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RegisterCommentDTO {
    @NotBlank
    @Size(max = 500)
    private String content;
}
