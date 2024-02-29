package com.develop.thankyounext.application.command.entity.post;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.post.PostRequest.RegisterPost;
import com.develop.thankyounext.domain.dto.result.ResultResponse.PostResult;
import com.develop.thankyounext.domain.entity.Member;
import com.develop.thankyounext.domain.entity.Post;
import com.develop.thankyounext.domain.entity.mapping.PostTag;
import com.develop.thankyounext.domain.repository.member.MemberRepository;
import com.develop.thankyounext.domain.repository.post.PostRepository;
import com.develop.thankyounext.domain.repository.tag.TagRepository;
import com.develop.thankyounext.global.manager.amazon.s3.AmazonS3Manger;
import com.develop.thankyounext.infrastructure.config.aws.AmazonConfig;
import com.develop.thankyounext.infrastructure.converter.ImageUrlListConverter;
import com.develop.thankyounext.infrastructure.converter.PostConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostCommandServiceImpl implements PostCommandService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final TagRepository tagRepository;

    private final PostConverter postConverter;

    // Amazon S3 Link
    private final AmazonS3Manger amazonS3Manger;
    private final AmazonConfig amazonConfig;
    private final ImageUrlListConverter imageUrlListConverter;

    @Override
    public PostResult registerPost(AuthenticationDto auth, RegisterPost request, List<MultipartFile> fileList) {

        // 임시 로직
        Member currentMember = memberRepository.getReferenceById(1L);

        // TODO: 인증 객체 생성 필요
//        Member currentMember = memberRepository.getReferenceById(auth.id());

        Post newPost = postConverter.toPost(request);
        newPost.setMember(currentMember);
        newPost.setImageUrlList(imageUrlListConverter.toImageUrlList(fileList, amazonS3Manger, amazonConfig));

        request.tagList().forEach(tagId -> {
            PostTag postTag = PostTag.builder().build();
            postTag.setPost(newPost);
            postTag.setTag(tagRepository.getReferenceById(tagId));
        });

        Post savePost = postRepository.save(newPost);

        return postConverter.toPostResult(savePost);
    }
}
