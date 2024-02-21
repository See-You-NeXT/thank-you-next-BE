package com.develop.thankyounext.application.module.entity.member;

import com.develop.thankyounext.domain.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberModuleServiceImpl implements MemberModuleService{

    private final MemberRepository memberRepository;
}
