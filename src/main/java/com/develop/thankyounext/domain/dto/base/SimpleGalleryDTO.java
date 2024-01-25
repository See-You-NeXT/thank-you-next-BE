package com.develop.thankyounext.domain.dto.base;

import lombok.Builder;

@Builder
public record SimpleGalleryDTO(
        String title,
        ContentDTO image
) {
}
