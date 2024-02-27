package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import com.develop.thankyounext.domain.embedded.LinkUrlList;
import com.develop.thankyounext.domain.enums.UserRoleEnum;
import lombok.Builder;

@Builder
public record MemberDto(
        Long id,
        UserRoleEnum role,
        String email,
        String password,
        String name,
        String description,
        String studentId,
        LinkUrlList linkUrlList,
        AuditingDto auditingDto
) {
}