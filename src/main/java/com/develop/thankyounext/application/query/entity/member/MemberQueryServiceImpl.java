package com.develop.thankyounext.application.query.entity.member;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.member.MemberResponse.GetMember;
import com.develop.thankyounext.domain.entity.Member;
import com.develop.thankyounext.domain.repository.member.MemberRepository;
import com.develop.thankyounext.global.exception.handler.MemberHandler;
import com.develop.thankyounext.global.payload.code.status.ErrorStatus;
import com.develop.thankyounext.infrastructure.converter.MemberConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    private final MemberConverter memberConverter;

    @Override
    public GetMember getProfile(AuthenticationDto auth) {
        Member currentMember = memberRepository.findById(1L)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        // TODO: 인증 객체 생성 필요
//        Member currentMember = memberRepository.findById(auth.id())
//                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return memberConverter.toGetMember(
                memberConverter.toDto(currentMember)
        );
    }
}
