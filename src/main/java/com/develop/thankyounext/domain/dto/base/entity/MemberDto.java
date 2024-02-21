package com.develop.thankyounext.domain.dto.base.entity;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import com.develop.thankyounext.domain.enums.UserRoleEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record MemberDto(
        Long id,
        UserRoleEnum role,
        String email,
        String password,
        String name,
        String description,
        String studentId,
        AuditingDto auditingDto
) {
}