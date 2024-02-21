package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import com.develop.thankyounext.domain.embedded.ImageUrlList;

public record GalleryDto(
        Long id,
        String title,
        ImageUrlList imageUrlList,
        AuditingDto auditingDto
) {
}
