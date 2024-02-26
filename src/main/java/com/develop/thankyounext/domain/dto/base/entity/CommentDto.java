package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import lombok.Builder;

@Builder
public record CommentDto(
        Long id,
        String author,
        String content,
        AuditingDto auditingDto
) {
}
