package com.develop.thankyounext.domain.dto.post;

import com.develop.thankyounext.domain.dto.base.entity.CommentDto;
import com.develop.thankyounext.domain.dto.base.entity.PostDto;
import com.develop.thankyounext.domain.dto.base.custom.SimplePostDto;
import com.develop.thankyounext.domain.dto.base.common.PageDto;
import lombok.Builder;

import java.util.List;

public class PostResponse {

    @Builder
    public record GetPostList(
            List<SimplePostDto> simplePostDtoList,
            PageDto pageDto
    ) {
    }

    @Builder
    public record GetPost(
            PostDto postDto,
            List<CommentDto> commentDtoList
    ) {
    }
}


