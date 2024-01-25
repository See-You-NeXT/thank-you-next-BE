package com.develop.thankyounext.domain.dto.base;

import lombok.Builder;

@Builder
public record BannerDTO(
        String title,
        String description,
        String url
) {
}
