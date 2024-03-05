package com.develop.thankyounext.application.command.entity.post;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.post.PostRequest.DeletePost;
import com.develop.thankyounext.domain.dto.post.PostRequest.RegisterPost;
import com.develop.thankyounext.domain.dto.post.PostRequest.UpdatePost;
import com.develop.thankyounext.domain.dto.result.ResultResponse.PostResult;
import com.develop.thankyounext.domain.entity.Image;
import com.develop.thankyounext.domain.entity.Member;
import com.develop.thankyounext.domain.entity.Post;
import com.develop.thankyounext.domain.entity.mapping.PostTag;
import com.develop.thankyounext.domain.repository.comment.CommentRepository;
import com.develop.thankyounext.domain.repository.image.ImageRepository;
import com.develop.thankyounext.domain.repository.mapping.post_tag.PostTagRepository;
import com.develop.thankyounext.domain.repository.member.MemberRepository;
import com.develop.thankyounext.domain.repository.post.PostRepository;
import com.develop.thankyounext.domain.repository.tag.TagRepository;
import com.develop.thankyounext.global.exception.handler.PostHandler;
import com.develop.thankyounext.global.manager.amazon.s3.AmazonS3Manger;
import com.develop.thankyounext.global.payload.code.status.ErrorStatus;
import com.develop.thankyounext.infrastructure.config.aws.AmazonConfig;
import com.develop.thankyounext.infrastructure.converter.ImageConverter;
import com.develop.thankyounext.infrastructure.converter.PostConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCommandServiceImpl implements PostCommandService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final TagRepository tagRepository;
    private final PostTagRepository postTagRepository;
    private final CommentRepository commentRepository;
    private final ImageRepository imageRepository;

    private final PostConverter postConverter;

    // Amazon S3 Link
    private final AmazonS3Manger amazonS3Manger;
    private final AmazonConfig amazonConfig;
    private final ImageConverter imageConverter;

    @Override
    public PostResult registerPost(AuthenticationDto auth, RegisterPost request, List<MultipartFile> fileList) {

        // 임시 로직
        Member currentMember = memberRepository.getReferenceById(1L);

        // TODO: 인증 객체 생성 필요
//        Member currentMember = memberRepository.getReferenceById(auth.id());

        Post newPost = postConverter.toPost(request);
        newPost.setMember(currentMember);

        List<PostTag> postTagList = (request.tagList() != null && !request.tagList().isEmpty()) ?
                createPostTags(request.tagList(), newPost) : null;
        List<Image> imageList = (fileList != null && !fileList.isEmpty()) ?
                createImages(fileList, newPost) : null;

        Post savePost = postRepository.save(newPost);

        if (postTagList != null) {
            postTagRepository.saveAll(postTagList);
        }
        if (imageList != null) {
            imageRepository.saveAll(imageList);
        }

        return postConverter.toPostResult(savePost);
    }

    @Override
    public PostResult updatePost(AuthenticationDto auth, UpdatePost request, List<MultipartFile> fileList) {

        Post currentPost = postRepository.findByIdWithMember(request.postId())
                .orElseThrow(() -> new PostHandler(ErrorStatus.POST_NOT_FOUND));

        // 임시 로직
        if (!currentPost.getMember().getId().equals(1L)) {
            throw new PostHandler(ErrorStatus.POST_NOT_AUTHOR_FORBIDDEN);
        }

        // TODO: 인증 객체 생성 필요
//        if (!currentPost.getMember().getId().equals(auth.id())) {
//            throw new PostHandler(ErrorStatus.POST_NOT_AUTHOR_FORBIDDEN);
//        }

        if (request.title() != null) {
            currentPost.updateTitle(request.title());
        }
        if (request.content() != null) {
            currentPost.updateContent(request.content());
        }

        if (request.tagList() != null && !request.tagList().isEmpty()) {
            postTagRepository.deleteAllByPostId(request.postId());
            List<PostTag> postTagList = createPostTags(request.tagList(), currentPost);
            postTagRepository.saveAll(postTagList);
        }

        if (fileList != null && !fileList.isEmpty()) {
            currentPost.getImageList().getImageList().forEach(image -> deleteImageFromS3(image.getUrl()));
            imageRepository.deleteAllByPostId(request.postId());
            List<Image> imageList = createImages(fileList, currentPost);
            currentPost.setImageList(imageConverter.toPostImageList(imageList));
            imageRepository.saveAll(imageList);
        }

        return postConverter.toPostResult(currentPost);
    }

    @Override
    public PostResult deletePost(AuthenticationDto auth, DeletePost request) {

        Post currentPost = postRepository.findByIdWithMember(request.postId())
                .orElseThrow(() -> new PostHandler(ErrorStatus.POST_NOT_FOUND));

        // 임시 로직
        if (!currentPost.getMember().getId().equals(1L)) {
            throw new PostHandler(ErrorStatus.POST_NOT_AUTHOR_FORBIDDEN);
        }

        // TODO: 인증 객체 생성 필요
//        if (!currentPost.getMember().getId().equals(auth.id())) {
//            throw new PostHandler(ErrorStatus.POST_NOT_AUTHOR_FORBIDDEN);
//        }

        PostResult postResult = postConverter.toPostResult(currentPost);

        currentPost.getImageList().getImageList().forEach(image -> deleteImageFromS3(image.getUrl()));

        imageRepository.deleteAllByPostId(request.postId());
        postTagRepository.deleteAllByPostId(request.postId());
        commentRepository.deleteAllByPostId(request.postId());
        postRepository.deleteById(currentPost.getId());

        return postResult;
    }

    private void deleteImageFromS3(String url) {
        amazonS3Manger.deleteImageForS3(amazonS3Manger.extractImageKeyFromUrl(url));
    }

    private List<PostTag> createPostTags(List<Long> tagIds, Post post) {
        return tagIds.stream().map(tagId -> {
            PostTag postTag = PostTag.builder().build();
            postTag.setPost(post);
            postTag.setTag(tagRepository.getReferenceById(tagId));
            return postTag;
        }).toList();
    }

    private List<Image> createImages(List<MultipartFile> fileList, Post post) {
        List<Image> imageList = fileList.stream().map(file -> {
            Image image = imageConverter.toImage(file, amazonS3Manger, amazonConfig.getPostPath());
            image.setPost(post);
            return image;
        }).toList();
        post.setImageList(imageConverter.toPostImageList(imageList));
        return imageList;
    }
}
