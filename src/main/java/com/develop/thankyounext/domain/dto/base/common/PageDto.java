package com.develop.thankyounext.domain.dto.base.common;

import lombok.Builder;

@Builder
public record PageDto(
        Integer listSize,
        Integer totalElements,
        Boolean isFirst,
        Boolean isLast
) {
}
