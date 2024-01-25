package com.develop.thankyounext.domain.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentRequest {
    public record RegisterCommentDTO(
            @NotBlank
            @Size(max = 500)
            String content
    ) {
    }

    public record DeleteCommentDTO(
            @NotNull
            Long commentId
    ) {
    }
}
