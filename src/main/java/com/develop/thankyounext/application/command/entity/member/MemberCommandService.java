package com.develop.thankyounext.application.command.entity.member;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.member.MemberRequest;
import com.develop.thankyounext.domain.dto.result.ResultResponse.MemberResult;

public interface MemberCommandService {
    MemberResult updateProfile(AuthenticationDto auth, MemberRequest.UpdateMember request);
}
