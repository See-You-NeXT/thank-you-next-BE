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

    @Mapping(source = "createdAt", target = "auditingDto.createdAt")
    @Mapping(source = "createdBy", target = "auditingDto.createdBy")
    @Mapping(source = "modifiedAt", target = "auditingDto.modifiedAt")
    MemberDto toDto(Member member);

    GetMember toGetMember(MemberDto memberDto);

    @Mapping(source = "id", target = "memberId")
    @Mapping(source = "modifiedAt", target = "executedAt")
    MemberResult toMemberResult(Member member);
}
