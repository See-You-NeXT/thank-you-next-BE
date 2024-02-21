package com.develop.thankyounext.application.module.entity.comment;

import com.develop.thankyounext.domain.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentModuleServiceImpl implements CommentModuleService{

    private final CommentRepository commentRepository;
}
