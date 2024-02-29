package com.develop.thankyounext.infrastructure.converter;

import com.develop.thankyounext.domain.dto.base.common.PageDto;
import com.develop.thankyounext.domain.dto.base.custom.SimplePostDto;
import com.develop.thankyounext.domain.dto.post.PostRequest.RegisterPost;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPostList;
import com.develop.thankyounext.domain.dto.result.ResultResponse.PostResult;
import com.develop.thankyounext.domain.entity.Member;
import com.develop.thankyounext.domain.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostConverter {

    PostConverter INSTANCE = Mappers.getMapper(PostConverter.class);

    @Mapping(source = "post.id", target = "id")
    @Mapping(source = "member.name", target = "author")
    @Mapping(source = "post.title", target = "title")
    @Mapping(source = "post.isSolved", target = "isSolved")
    @Mapping(source = "post", target = "auditingDto")
    SimplePostDto toSimplePostDto(Post post, Member member);

    @Mapping(source = "registerPost.dType", target = "dType")
    @Mapping(source = "registerPost.title", target = "title")
    @Mapping(source = "registerPost.content", target = "content")
    Post toPost(RegisterPost registerPost);

    default PageDto toPageDto(Page<Post> posts){
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

    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "post.createdAt", target = "executedAt")
    PostResult toPostResult(Post post);
}
