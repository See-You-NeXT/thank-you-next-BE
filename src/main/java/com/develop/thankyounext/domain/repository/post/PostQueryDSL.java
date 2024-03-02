package com.develop.thankyounext.domain.repository.post;

import com.develop.thankyounext.domain.entity.Post;
import com.develop.thankyounext.domain.enums.PostEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostQueryDSL {

    Page<Post> findAllByMemberId(Long memberId, Pageable pageable);

    Page<Post> findAllByConditions(PostEnum dType, List<Long> tagList, String keyword, Pageable pageable);

    Optional<Post> findByIdWithCommentAndMember(Long postId);

    Optional<Post> findByIdWithMember(Long postId);
}
