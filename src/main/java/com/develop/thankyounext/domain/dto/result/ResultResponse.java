package com.develop.thankyounext.domain.dto.result;

import lombok.Builder;

import java.time.LocalDateTime;

public class ResultResponse {

    @Builder
    public record AuthResult(
            Long memberId,
            LocalDateTime createdAt
    ) {
    }

    @Builder
    public record MemberResult(
            Long memberId,
            LocalDateTime executedAt
    ) {
    }

    @Builder
    public record GalleryResult(
            Long galleryId,
            LocalDateTime executedAt
    ) {
    }

    @Builder
    public record CommentResult(
            Long commentId,
            LocalDateTime executedAt
    ) {
    }

    @Builder
    public record PostResult(
            Long postId,
            LocalDateTime executedAt
    ) {
    }
}
