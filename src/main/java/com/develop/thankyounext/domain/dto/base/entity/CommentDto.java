package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;

public record CommentDto(
        Long id,
        String author,
        String content,
        AuditingDto auditingDto
) {
}
