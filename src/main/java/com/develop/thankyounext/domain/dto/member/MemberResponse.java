package com.develop.thankyounext.domain.dto.member;

import com.develop.thankyounext.domain.dto.base.common.AuditingDto;
import com.develop.thankyounext.domain.dto.base.entity.MemberDto;

public class MemberResponse {

    public record GetMember(
            MemberDto memberDto
    ) {
    }
}

