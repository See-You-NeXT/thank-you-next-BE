package com.develop.thankyounext.domain.dto.base.custom;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;

public record SimplePostDto(
        Long id,
        String author,
        String title,
        Boolean isSolved,
        AuditingDto auditingDto
) {
}
