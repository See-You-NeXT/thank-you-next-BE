package com.develop.thankyounext.application.query.entity.member;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.base.common.PageDto;
import com.develop.thankyounext.domain.dto.base.custom.SimplePostDto;
import com.develop.thankyounext.domain.dto.member.MemberResponse.GetMember;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPostList;
import com.develop.thankyounext.domain.entity.Member;
import com.develop.thankyounext.domain.entity.Post;
import com.develop.thankyounext.domain.repository.comment.CommentRepository;
import com.develop.thankyounext.domain.repository.member.MemberRepository;
import com.develop.thankyounext.domain.repository.post.PostRepository;
import com.develop.thankyounext.infrastructure.converter.MemberConverter;
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
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    private final MemberConverter memberConverter;
    private final PostConverter postConverter;

    @Override
    public GetMember getProfile(AuthenticationDto auth) {

        Member currentMember = memberRepository.getReferenceById(1L);

        // TODO: 인증 객체 생성 필요
//        Member currentMember = memberRepository.getReferenceById(auth.id());

        return memberConverter.toGetMember(
                memberConverter.toDto(currentMember)
        );
    }

    @Override
    public GetPostList getPostsByMember(AuthenticationDto auth, Pageable pageable) {

        Member currentMember = memberRepository.getReferenceById(1L);
        Page<Post> posts = postRepository.findAllByMemberId(1L, pageable);

        // TODO: 인증 객체 생성 필요
//        Member currentMember = memberRepository.getReferenceById(auth.id());
//        Page<Post> posts = postRepository.findAllByMemberId(auth.id(), pageable);

        return createGetPostList(currentMember, posts);
    }

    @Override
    public GetPostList getPostsByMemberCommented(AuthenticationDto auth, Pageable pageable) {

        Member currentMember = memberRepository.getReferenceById(1L);
        Page<Post> posts = commentRepository.findPostsByMemberCommented(1L, pageable);

        // TODO: 인증 객체 생성 필요
//        Member currentMember = memberRepository.getReferenceById(auth.id());
//        Page<Post> posts = commentRepository.findPostsByMemberCommented(auth.id(), pageable);

        return createGetPostList(currentMember, posts);
    }

    private GetPostList createGetPostList(Member currentMember, Page<Post> posts) {
        List<SimplePostDto> simplePostDtos = posts.stream().map(post -> postConverter.toSimplePostDto(post, currentMember)).toList();
        PageDto pageDto = postConverter.toPageDto(posts);

        return postConverter.toGetPostList(simplePostDtos, pageDto);
    }
}
