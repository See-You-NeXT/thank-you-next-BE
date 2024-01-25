package com.develop.thankyounext.domain.dto.base;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentDTO(
        String author,
        String content,
        LocalDateTime created
) {
}
