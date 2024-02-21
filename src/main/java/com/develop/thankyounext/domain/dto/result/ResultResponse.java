package com.develop.thankyounext.domain.dto.result;

import java.time.LocalDateTime;

public class ResultResponse {

    public record AuthResult(
            Long memberId,
            LocalDateTime createdAt
    ) {
    }

    public record MemberResult(
            Long memberId,
            LocalDateTime executedAt
    ) {
    }

    public record GalleryResult(
            Long galleryId,
            LocalDateTime executedAt
    ) {
    }

    public record CommentResult(
            Long commentId,
            LocalDateTime executedAt
    ) {
    }

    public record PostResult(
            Long postId,
            LocalDateTime executedAt
    ) {
    }
}
