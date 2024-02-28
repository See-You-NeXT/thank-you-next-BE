package com.develop.thankyounext.domain.dto.member;

import com.develop.thankyounext.domain.dto.base.entity.MemberDto;
import lombok.Builder;

public class MemberResponse {

    @Builder
    public record GetMember(
            MemberDto memberDto
    ) {
    }
}

