package com.develop.thankyounext.domain.dto.base;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentDTO {
    private String author;
    @NotBlank
    @Size(max = 500)
    private String content;
    private LocalDateTime createdAt;
}
