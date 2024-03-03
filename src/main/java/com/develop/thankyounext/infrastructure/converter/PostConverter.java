package com.develop.thankyounext.infrastructure.converter;

import com.develop.thankyounext.domain.dto.base.common.PageDto;
import com.develop.thankyounext.domain.dto.base.custom.SimplePostDto;
import com.develop.thankyounext.domain.dto.base.entity.CommentDto;
import com.develop.thankyounext.domain.dto.base.entity.PostDto;
import com.develop.thankyounext.domain.dto.post.PostRequest.RegisterPost;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPost;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPostList;
import com.develop.thankyounext.domain.dto.result.ResultResponse.PostResult;
import com.develop.thankyounext.domain.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostConverter {

    PostConverter INSTANCE = Mappers.getMapper(PostConverter.class);

    @Mapping(source = "member.name", target = "author")
    @Mapping(source = "createdAt", target = "auditingDto.createdAt")
    @Mapping(source = "createdBy", target = "auditingDto.createdBy")
    @Mapping(source = "modifiedAt", target = "auditingDto.modifiedAt")
    SimplePostDto toSimplePostDto(Post post);

    @Mapping(source = "DType", target = "dType")
    @Mapping(source = "createdAt", target = "auditingDto.createdAt")
    @Mapping(source = "createdBy", target = "auditingDto.createdBy")
    @Mapping(source = "modifiedAt", target = "auditingDto.modifiedAt")
    PostDto toPostDto(Post post);

    Post toPost(RegisterPost registerPost);

    GetPost toGetPost(PostDto postDto, List<CommentDto> commentDtoList);

    default PageDto toPageDto(Page<Post> posts) {
        return PageDto.builder()
                .listSize(posts.getSize())
                .totalElements(posts.getTotalElements())
                .isFirst(!posts.hasPrevious())
                .isLast(!posts.hasNext())
                .build();
    }

    default GetPostList toGetPostList(List<SimplePostDto> simplePostDtoList, PageDto pageDto) {
        return GetPostList.builder()
                .simplePostDtoList(simplePostDtoList)
                .pageDto(pageDto)
                .build();
    }

    @Mapping(source = "id", target = "postId")
    @Mapping(source = "createdAt", target = "executedAt", defaultExpression = "java(java.time.LocalDateTime.now())")
    PostResult toPostResult(Post post);
}
