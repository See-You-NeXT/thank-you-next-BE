package com.develop.thankyounext.domain.dto.base;

import com.develop.thankyounext.domain.enums.SolvedEnum;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SimplePostDTO(
        String author,
        String title,
        SolvedEnum isSolved,
        LocalDateTime createdAt
) {
}
