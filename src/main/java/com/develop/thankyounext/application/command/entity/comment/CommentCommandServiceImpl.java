package com.develop.thankyounext.application.command.entity.comment;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.RegisterComment;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.UpdateComment;
import com.develop.thankyounext.domain.dto.result.ResultResponse.CommentResult;
import com.develop.thankyounext.domain.entity.Comment;
import com.develop.thankyounext.domain.entity.Member;
import com.develop.thankyounext.domain.entity.Post;
import com.develop.thankyounext.domain.repository.comment.CommentRepository;
import com.develop.thankyounext.domain.repository.member.MemberRepository;
import com.develop.thankyounext.domain.repository.post.PostRepository;
import com.develop.thankyounext.global.exception.handler.CommentHandler;
import com.develop.thankyounext.global.payload.code.status.ErrorStatus;
import com.develop.thankyounext.infrastructure.converter.CommentConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentCommandServiceImpl implements CommentCommandService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    private final CommentConverter commentConverter;

    @Override
    public CommentResult registerComment(AuthenticationDto auth, Long postId, RegisterComment request) {

        Member currentMember = memberRepository.getReferenceById(1L);

        // TODO: 인증 객체 생성 필요
//        Member currentMember = memberRepository.getReferenceById(auth.id());
        Post currentPost = postRepository.getReferenceById(postId);
        Comment newComment = commentConverter.toComment(request);

        newComment.setMember(currentMember);
        newComment.setPost(currentPost);

        if (request.parentId() != null) {
            Comment parentComment = commentRepository.getReferenceById(request.parentId());
            newComment.setParent(parentComment);
        }

        Comment saveComment = commentRepository.save(newComment);

        return commentConverter.toCommentResult(saveComment);
    }

    @Override
    public CommentResult updateComment(AuthenticationDto auth, Long postId, UpdateComment request) {

        Comment currentComment = commentRepository.findById(request.commentId())
                .orElseThrow(() -> new CommentHandler(ErrorStatus.COMMENT_NOT_FOUND));


        if (!currentComment.getMember().getId().equals(1L)) {
            throw new CommentHandler(ErrorStatus.COMMENT_NOT_AUTHOR_FORBIDDEN);
        }

        // TODO: 인증 객체 생성 필요
//        if (!currentComment.getMember().getId().equals(auth.id())) {
//            throw new CommentHandler(ErrorStatus.COMMENT_NOT_AUTHOR_FORBIDDEN);
//        }

        if (request.content() != null) {
            currentComment.updateContent(request.content());
        }

        return commentConverter.toCommentResult(currentComment);
    }
}
