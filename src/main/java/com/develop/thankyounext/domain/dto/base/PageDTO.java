package com.develop.thankyounext.domain.dto.base;

public record PageDTO(
        Integer listSize,
        Integer totalElements,
        Boolean isFirst,
        Boolean isLast
) {
}
