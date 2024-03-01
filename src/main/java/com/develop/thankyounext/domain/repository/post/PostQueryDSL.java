package com.develop.thankyounext.domain.repository.post;

import com.develop.thankyounext.domain.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PostQueryDSL {

    Page<Post> findAllByMemberId(Long memberId, Pageable pageable);

    Optional<Post> findByIdWithLeftJoin(Long postId);
}
