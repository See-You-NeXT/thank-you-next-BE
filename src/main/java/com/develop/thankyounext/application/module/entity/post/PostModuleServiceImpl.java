package com.develop.thankyounext.application.module.entity.post;

import com.develop.thankyounext.domain.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostModuleServiceImpl implements PostModuleService{

    private final PostRepository postRepository;
}
