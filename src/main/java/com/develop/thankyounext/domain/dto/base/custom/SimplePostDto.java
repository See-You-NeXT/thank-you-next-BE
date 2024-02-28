package com.develop.thankyounext.domain.dto.base.custom;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import com.develop.thankyounext.domain.enums.SolvedEnum;
import lombok.Builder;

@Builder
public record SimplePostDto(
        Long id,
        String author,
        String title,
        SolvedEnum isSolved,
        AuditingDto auditingDto
) {
}
