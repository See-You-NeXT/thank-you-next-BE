package com.develop.thankyounext.domain.dto.base.common;

import java.time.LocalDateTime;

public record AuditingDto(
        String createdBy,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {
}
