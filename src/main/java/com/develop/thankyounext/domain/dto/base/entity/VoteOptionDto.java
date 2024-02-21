package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;

public record VoteOptionDto(
        Long id,
        String content,
        Long count,
        AuditingDto auditingDto
) {
}
