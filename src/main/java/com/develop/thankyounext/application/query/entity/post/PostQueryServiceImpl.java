package com.develop.thankyounext.application.query.entity.post;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPost;
import com.develop.thankyounext.domain.entity.Post;
import com.develop.thankyounext.domain.repository.post.PostRepository;
import com.develop.thankyounext.global.exception.handler.PostHandler;
import com.develop.thankyounext.global.payload.code.status.ErrorStatus;
import com.develop.thankyounext.infrastructure.converter.CommentConverter;
import com.develop.thankyounext.infrastructure.converter.PostConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostQueryServiceImpl implements PostQueryService {

    private final PostRepository postRepository;

    private final PostConverter postConverter;
    private final CommentConverter commentConverter;

    @Override
    public GetPost getPost(AuthenticationDto auth, Long postId) {

        Post post = postRepository.findByIdWithInnerJoin(postId)
                .orElseThrow(() -> new PostHandler(ErrorStatus.POST_NOT_FOUND));

        return postConverter.toGetPost(postConverter.toPostDto(post), post.getCommentList().stream()
                .map(commentConverter::toCommentDto).toList());
    }
}
