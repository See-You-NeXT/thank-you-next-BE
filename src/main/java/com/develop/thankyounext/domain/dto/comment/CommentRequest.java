package com.develop.thankyounext.domain.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentRequest {

    public record RegisterComment(
            @NotBlank
            @Size(max = 500)
            String content
    ) {
    }

    public record UpdateComment(
            @NotNull
            Long commentId,
            @NotBlank
            @Size(max = 500)
            String content
    ) {
    }

    public record DeleteComment(
            @NotNull
            Long commentId
    ) {
    }

}
