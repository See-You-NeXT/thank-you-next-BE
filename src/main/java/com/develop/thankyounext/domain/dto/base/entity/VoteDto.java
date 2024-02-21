package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;

public record VoteDto(
        Long id,
        String title,
        String description,
        AuditingDto auditingDto
) {
}
