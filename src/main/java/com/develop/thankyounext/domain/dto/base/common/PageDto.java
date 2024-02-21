package com.develop.thankyounext.domain.dto.base.common;

public record PageDto(
        Integer listSize,
        Integer totalElements,
        Boolean isFirst,
        Boolean isLast
) {
}
