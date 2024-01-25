package com.develop.thankyounext.domain.dto.post;

import com.develop.thankyounext.domain.dto.base.CommentDTO;
import com.develop.thankyounext.domain.dto.base.SimplePostDTO;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class PostResponse {

    @Builder
    public record GetPostList(
            List<SimplePostDTO> simplePostDTOList,

            // Paging
            Integer listSize,
            Integer totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {
    }

    @Builder
    public record GetPost(
            String author,
            String title,
            String content,
            Boolean isSolved,
            List<CommentDTO> commentDTOList,
            LocalDateTime createdAt
    ) {
    }
}


