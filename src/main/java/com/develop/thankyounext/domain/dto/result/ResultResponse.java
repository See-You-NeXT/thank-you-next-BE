package com.develop.thankyounext.domain.dto.result;

import java.time.LocalDateTime;

public class ResultResponse {

    public record AuthResultDTO(
            Long memberId,
            LocalDateTime createdAt
    ) {
    }

    public record MemberResultDTO(
            Long memberId,
            LocalDateTime executedAt
    ) {
    }

    public record GalleryResultDTO(
            Long galleryId,
            LocalDateTime executedAt
    ) {
    }

    public record CommentResultDTO(
            Long commentId,
            LocalDateTime executedAt
    ) {
    }

    public record PostResultDTO(
            Long postId,
            LocalDateTime executedAt
    ) {
    }
}
