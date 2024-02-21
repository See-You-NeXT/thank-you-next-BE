package com.develop.thankyounext.domain.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PostRequest {

    public record RegisterPost(
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

    public record UpdatePost(
            @NotBlank
            @Size(max = 50)
            String title,
            @NotBlank
            @Size(max = 2000)
            String content,
            List<String> tagList
    ) {
    }

    public record DeletePost(
            @NotNull
            Long postId
    ) {
    }
}
