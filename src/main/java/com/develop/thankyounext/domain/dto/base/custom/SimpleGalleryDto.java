package com.develop.thankyounext.domain.dto.base.custom;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import lombok.Builder;

@Builder
public record SimpleGalleryDto(
        Long id,
        String title,
        String imageUrl,
        AuditingDto auditingDto
) {
}
