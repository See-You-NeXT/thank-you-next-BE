package com.develop.thankyounext.domain.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;

public class PostRequest {
    public record RegisterPostDTO(
            @NotNull
            String dType,
            @NotBlank
            @Size(max = 50)
            String title,
            @NotBlank
            @Size(max = 2000)
            String content,
            List<String> tagList
    ) {
    }

    public record UpdatePostDTO(
            @NotBlank
            @Size(max = 50)
            String title,
            @NotBlank
            @Size(max = 2000)
            String content,
            List<String> tagList
    ) {
    }

    public record DeletePostDTO(
            @NotNull
            Long postId
    ) {
    }
}
