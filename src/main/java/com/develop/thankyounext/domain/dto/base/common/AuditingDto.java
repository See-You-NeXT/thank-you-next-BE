package com.develop.thankyounext.domain.dto.base.common;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AuditingDto(
        String createdBy,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {
}
