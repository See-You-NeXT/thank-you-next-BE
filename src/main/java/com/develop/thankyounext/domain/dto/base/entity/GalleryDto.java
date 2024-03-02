package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import com.develop.thankyounext.domain.entity.embedded.GalleryImageList;
import lombok.Builder;

@Builder
public record GalleryDto(
        Long id,
        String title,
        GalleryImageList imageUrlList,
        AuditingDto auditingDto
) {
}
