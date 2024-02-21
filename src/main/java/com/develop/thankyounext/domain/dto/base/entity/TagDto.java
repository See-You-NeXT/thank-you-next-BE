package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;

public record TagDto(
        Long id,
        String name,
        AuditingDto auditingDto
) {
}
