package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import lombok.Builder;

@Builder
public record BannerDto(
        Long id,
        String title,
        String description,
        String linkUrl,
        AuditingDto auditingDto
) {
}
