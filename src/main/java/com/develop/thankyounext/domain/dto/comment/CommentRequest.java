package com.develop.thankyounext.domain.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

public class CommentRequest {
    @Builder
    public record RegisterCommentDTO(
            @NotBlank
            @Size(max = 500)
            String content
    ) {
    }

    @Builder
    public record DeleteCommentDTO(
            @NotNull
            Long commentId
    ) {
    }
}
