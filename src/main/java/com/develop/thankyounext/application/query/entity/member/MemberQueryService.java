package com.develop.thankyounext.application.query.entity.member;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.member.MemberResponse.GetMember;

public interface MemberQueryService {
    GetMember getProfile(AuthenticationDto auth);
}
