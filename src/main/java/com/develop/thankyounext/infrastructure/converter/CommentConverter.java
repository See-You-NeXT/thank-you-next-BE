package com.develop.thankyounext.infrastructure.converter;

import com.develop.thankyounext.domain.dto.base.entity.CommentDto;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.RegisterComment;
import com.develop.thankyounext.domain.dto.result.ResultResponse.CommentResult;
import com.develop.thankyounext.domain.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentConverter {

    CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);

    @Mapping(source = "member.name", target = "author")
    @Mapping(source = "createdAt", target = "auditingDto.createdAt")
    @Mapping(source = "createdBy", target = "auditingDto.createdBy")
    @Mapping(source = "modifiedAt", target = "auditingDto.modifiedAt")
    CommentDto toCommentDto(Comment comment);

    Comment toComment(RegisterComment registerComment);

    @Mapping(source = "id", target = "commentId")
    @Mapping(source = "createdAt", target = "executedAt")
    CommentResult toCommentResult(Comment comment);
}
