package com.develop.thankyounext.domain.dto.base.custom;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import com.develop.thankyounext.domain.entity.embedded.GalleryImageList;
import lombok.Builder;

@Builder
public record SimpleGalleryDto(
        Long id,
        String title,
        GalleryImageList imageUrl,
        AuditingDto auditingDto
) {
}
