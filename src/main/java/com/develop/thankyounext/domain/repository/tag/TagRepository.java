package com.develop.thankyounext.domain.repository.tag;

import com.develop.thankyounext.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long>, TagQueryDSL {
}
