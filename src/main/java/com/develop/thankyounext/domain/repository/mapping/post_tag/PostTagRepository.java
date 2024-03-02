package com.develop.thankyounext.domain.repository.mapping.post_tag;

import com.develop.thankyounext.domain.entity.mapping.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTagRepository extends JpaRepository<PostTag, Long>, PostTagQueryDSL {
}
