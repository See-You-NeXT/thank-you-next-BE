package com.develop.thankyounext.application.query.entity.post;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPost;

public interface PostQueryService {
    GetPost getPost(AuthenticationDto auth, Long postId);
}
