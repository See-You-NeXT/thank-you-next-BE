package com.develop.thankyounext.infrastructure.converter;

import com.develop.thankyounext.domain.dto.base.entity.MemberDto;
import com.develop.thankyounext.domain.dto.member.MemberResponse.GetMember;
import com.develop.thankyounext.domain.dto.result.ResultResponse.MemberResult;
import com.develop.thankyounext.domain.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MemberConverter {

    MemberConverter INSTANCE = Mappers.getMapper(MemberConverter.class);

    @Mapping(source = "member.id", target = "id")
    @Mapping(source = "member.role", target = "role")
    @Mapping(source = "member.email", target = "email")
    @Mapping(source = "member.password", target = "password")
    @Mapping(source = "member.name", target = "name")
    @Mapping(source = "member.description", target = "description")
    @Mapping(source = "member.studentId", target = "studentId")
    @Mapping(source = "member.linkUrlList", target = "linkUrlList")
    @Mapping(source = "member", target = "auditingDto")
    MemberDto toDto(Member member);

    GetMember toGetMember(MemberDto memberDto);

    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "member.modifiedAt", target = "executedAt")
    MemberResult toMemberResult(Member member);
}
