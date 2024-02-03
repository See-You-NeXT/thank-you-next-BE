package com.develop.thankyounext.domain.repository.post;

import com.develop.thankyounext.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostQueryDSL {
}
