package com.develop.thankyounext.application.query.entity.post;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.base.common.PageDto;
import com.develop.thankyounext.domain.dto.base.custom.SimplePostDto;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPost;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPostList;
import com.develop.thankyounext.domain.entity.Post;
import com.develop.thankyounext.domain.enums.PostEnum;
import com.develop.thankyounext.domain.repository.post.PostRepository;
import com.develop.thankyounext.global.exception.handler.PostHandler;
import com.develop.thankyounext.global.payload.code.status.ErrorStatus;
import com.develop.thankyounext.infrastructure.converter.CommentConverter;
import com.develop.thankyounext.infrastructure.converter.PostConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostQueryServiceImpl implements PostQueryService {

    private final PostRepository postRepository;

    private final PostConverter postConverter;
    private final CommentConverter commentConverter;

    @Override
    public GetPost getPost(AuthenticationDto auth, Long postId) {

        Post post = postRepository.findByIdWithCommentAndMember(postId)
                .orElseThrow(() -> new PostHandler(ErrorStatus.POST_NOT_FOUND));

        return postConverter.toGetPost(postConverter.toPostDto(post), post.getCommentList().stream()
                .map(commentConverter::toCommentDto).toList());
    }

    @Override
    public GetPostList getPostsByKeyword(PostEnum dType, List<Long> tagList, String keyword, Pageable pageable) {

        Page<Post> findPosts = postRepository.findAllByConditions(dType, tagList, keyword, pageable);

        return createGetPostList(findPosts);
    }

    private GetPostList createGetPostList(Page<Post> posts) {
        List<SimplePostDto> simplePostDtos = posts.stream().map(postConverter::toSimplePostDto).toList();
        PageDto pageDto = postConverter.toPageDto(posts);

        return postConverter.toGetPostList(simplePostDtos, pageDto);
    }
}
