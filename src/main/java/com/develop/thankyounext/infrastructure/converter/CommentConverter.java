package com.develop.thankyounext.infrastructure.converter;

import com.develop.thankyounext.domain.dto.comment.CommentRequest.RegisterComment;
import com.develop.thankyounext.domain.dto.result.ResultResponse.CommentResult;
import com.develop.thankyounext.domain.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentConverter {

    CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);

    @Mapping(source = "registerComment.content", target = "content")
    Comment toComment(RegisterComment registerComment);

    @Mapping(source = "comment.id", target = "commentId")
    @Mapping(source = "comment.createdAt", target = "executedAt")
    CommentResult toCommentResult(Comment comment);

}
