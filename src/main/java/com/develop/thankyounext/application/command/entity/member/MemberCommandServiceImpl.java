package com.develop.thankyounext.application.command.entity.member;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.member.MemberRequest.UpdateMember;
import com.develop.thankyounext.domain.dto.result.ResultResponse.MemberResult;
import com.develop.thankyounext.domain.entity.Member;
import com.develop.thankyounext.domain.repository.member.MemberRepository;
import com.develop.thankyounext.global.exception.handler.MemberHandler;
import com.develop.thankyounext.global.payload.code.status.ErrorStatus;
import com.develop.thankyounext.infrastructure.converter.MemberConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final MemberConverter memberConverter;

    @Override
    public MemberResult updateProfile(AuthenticationDto auth, UpdateMember request) {

        // 임시 로직
        Member currentMember = memberRepository.getReferenceById(1L);

        // TODO: 인증 객체 생성 필요
//        Member currentMember = memberRepository.getReferenceById(auth.id());

        updateMember(request, currentMember);

        return memberConverter.toMemberResult(currentMember);
    }

    private static void updateMember(UpdateMember request, Member currentMember) {
        if (request.password() != null) {
            if (request.password().equals(request.passwordCheck())) {
                currentMember.updatePassword(request.password());
            }
            throw new MemberHandler(ErrorStatus.MEMBER_UPDATE_PASSWORD_NOT_EQUAL_BAD_REQUEST);
        }

        if (request.name() != null) {
            currentMember.updateName(request.name());
        }

        if (request.description() != null) {
            currentMember.updateDescription(request.description());
        }

        if (request.studentId() != null) {
            currentMember.updateStudentId(request.studentId());
        }

        if (request.linkUrlList() != null) {
            currentMember.updateLinkUrlList(request.linkUrlList());
        }
    }
}
