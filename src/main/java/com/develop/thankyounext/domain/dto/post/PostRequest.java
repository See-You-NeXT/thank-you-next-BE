package com.develop.thankyounext.domain.dto.post;

import com.develop.thankyounext.domain.enums.PostEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PostRequest {

    public record RegisterPost(
            @NotNull
            PostEnum dType,
            @NotBlank
            @Size(max = 50)
            String title,
            @NotBlank
            @Size(max = 2000)
            String content,
            List<Long> tagList
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
