package com.develop.thankyounext.application.query.entity.post;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPost;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPostList;
import com.develop.thankyounext.domain.enums.PostEnum;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostQueryService {
    GetPost getPost(AuthenticationDto auth, Long postId);

    GetPostList getPostsByKeyword(PostEnum dType, List<Long> tagList, String keyword, Pageable pageable);
}
