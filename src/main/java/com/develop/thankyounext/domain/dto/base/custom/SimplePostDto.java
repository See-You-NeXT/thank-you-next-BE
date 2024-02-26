package com.develop.thankyounext.domain.dto.base.custom;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import lombok.Builder;

@Builder
public record SimplePostDto(
        Long id,
        String author,
        String title,
        Boolean isSolved,
        AuditingDto auditingDto
) {
}
