package com.develop.thankyounext.domain.repository.comment;

import com.develop.thankyounext.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentQueryDSL {
}
