package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import com.develop.thankyounext.domain.entity.embedded.PostImageList;
import com.develop.thankyounext.domain.enums.PostEnum;
import com.develop.thankyounext.domain.enums.SolvedEnum;
import lombok.Builder;

@Builder
public record PostDto(
        Long id,
        String title,
        String content,
        PostEnum dType,
        SolvedEnum isSolved,
        PostImageList imageList,
        AuditingDto auditingDto
) {
}
