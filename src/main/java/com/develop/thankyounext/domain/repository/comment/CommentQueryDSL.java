package com.develop.thankyounext.domain.repository.comment;

import com.develop.thankyounext.domain.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentQueryDSL {

    Page<Post> findPostsByMemberCommented(Long memberId, Pageable pageable);
}
