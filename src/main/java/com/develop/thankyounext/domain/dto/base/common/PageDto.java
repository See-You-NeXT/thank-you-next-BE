package com.develop.thankyounext.domain.dto.base.common;

import lombok.Builder;

@Builder
public record PageDto(
        Integer listSize,
        Long totalElements,
        Boolean isFirst,
        Boolean isLast
) {
}
