package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import lombok.Builder;

@Builder
public record VoteDto(
        Long id,
        String title,
        String description,
        AuditingDto auditingDto
) {
}
