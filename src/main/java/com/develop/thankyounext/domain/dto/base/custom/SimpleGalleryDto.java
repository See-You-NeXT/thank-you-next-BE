package com.develop.thankyounext.domain.dto.base.custom;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;

public record SimpleGalleryDto(
        Long id,
        String title,
        String imageUrl,
        AuditingDto auditingDto
) {
}
