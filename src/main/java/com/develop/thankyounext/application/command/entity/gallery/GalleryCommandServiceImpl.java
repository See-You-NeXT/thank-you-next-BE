package com.develop.thankyounext.application.command.entity.gallery;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.comment.CommentRequest;
import com.develop.thankyounext.domain.dto.gallery.GalleryRequest;
import com.develop.thankyounext.domain.dto.gallery.GalleryRequest.RegisterGallery;
import com.develop.thankyounext.domain.dto.result.ResultResponse;
import com.develop.thankyounext.domain.dto.result.ResultResponse.GalleryResult;
import com.develop.thankyounext.domain.entity.Comment;
import com.develop.thankyounext.domain.entity.Gallery;
import com.develop.thankyounext.domain.entity.Image;
import com.develop.thankyounext.domain.entity.Member;
import com.develop.thankyounext.domain.repository.comment.CommentRepository;
import com.develop.thankyounext.domain.repository.gallery.GalleryRepository;
import com.develop.thankyounext.domain.repository.image.ImageRepository;
import com.develop.thankyounext.domain.repository.member.MemberRepository;
import com.develop.thankyounext.global.exception.handler.CommentHandler;
import com.develop.thankyounext.global.exception.handler.GalleryHandler;
import com.develop.thankyounext.global.manager.amazon.s3.AmazonS3Manger;
import com.develop.thankyounext.global.payload.code.BaseErrorCode;
import com.develop.thankyounext.global.payload.code.status.ErrorStatus;
import com.develop.thankyounext.infrastructure.config.aws.AmazonConfig;
import com.develop.thankyounext.infrastructure.converter.CommentConverter;
import com.develop.thankyounext.infrastructure.converter.GalleryConverter;
import com.develop.thankyounext.infrastructure.converter.ImageConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class GalleryCommandServiceImpl implements GalleryCommandService {
    private final ImageRepository imageRepository;

    private final GalleryRepository galleryRepository;

    private final CommentRepository commentRepository;

    private final MemberRepository memberRepository;

    private final GalleryConverter galleryConverter;
    private final ImageConverter imageConverter;
    private final CommentConverter commentConverter;

    // Amazon S3 Link
    private final AmazonS3Manger amazonS3Manger;
    private final AmazonConfig amazonConfig;

    @Override
    public GalleryResult registerGallery(AuthenticationDto auth, RegisterGallery request, List<MultipartFile> fileList) {

        Gallery newGallery = galleryConverter.toGallery(request);

        List<Image> imageList = createImages(fileList, newGallery);

        Gallery saveGallery = galleryRepository.save(newGallery);
        imageRepository.saveAll(imageList);

        return galleryConverter.toGalleryResult(saveGallery);
    }

    @Override
    public GalleryResult updateGallery(AuthenticationDto auth, GalleryRequest.UpdateGallery request, List<MultipartFile> fileList) {

        Gallery currentGallery = galleryRepository.findById(request.galleryId()).orElseThrow(
                () -> new GalleryHandler(ErrorStatus.GALLERY_NOT_FOUND)
        );

        if (request.title() != null) {
            currentGallery.updateTitle(request.title());
        }

        if (fileList != null && !fileList.isEmpty()) {
            currentGallery.getImageList().getImageList().forEach(image -> deleteImageFromS3(image.getUrl()));
            imageRepository.deleteAllByGalleryId(request.galleryId());
            List<Image> imageList = createImages(fileList, currentGallery);
            currentGallery.setImageList(imageConverter.toGalleryImageList(imageList));
            imageRepository.saveAll(imageList);
        }

        return galleryConverter.toGalleryResult(currentGallery);
    }

    @Override
    public GalleryResult deleteGallery(AuthenticationDto auth, GalleryRequest.DeleteGallery request) {
        Gallery savedGallery = galleryRepository.findById(request.galleryId()).orElseThrow();

        GalleryResult galleryResult = galleryConverter.toGalleryResult(savedGallery);

        imageRepository.deleteAllByGalleryId(request.galleryId());
        commentRepository.deleteAllByGalleryId(request.galleryId());
        galleryRepository.delete(savedGallery);

        return galleryResult;
    }

    @Override
    public ResultResponse.CommentResult registerComment(AuthenticationDto auth, Long galleryId, CommentRequest.RegisterComment request) {

        // 임시 로직
        Member currentMember = memberRepository.getReferenceById(1L);

        // TODO: 인증 객체 생성 필요
//        Member currentMember = memberRepository.getReferenceById(auth.id());
        Gallery currentGallery = galleryRepository.getReferenceById(galleryId);
        Comment newComment = commentConverter.toComment(request);

        newComment.setMember(currentMember);
        newComment.setGallery(currentGallery);

        if (request.parentId() != null) {
            Comment parentComment = commentRepository.getReferenceById(request.parentId());
            newComment.setParent(parentComment);
        }

        Comment saveComment = commentRepository.save(newComment);

        return commentConverter.toCommentResult(saveComment);
    }

    @Override
    public ResultResponse.CommentResult updateComment(AuthenticationDto auth, CommentRequest.UpdateComment request) {
        Comment currentComment = commentRepository.findById(request.commentId())
                .orElseThrow(() -> new CommentHandler(ErrorStatus.COMMENT_NOT_FOUND));


        // 임시 로직
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

    @Override
    public ResultResponse.CommentResult deleteComment(AuthenticationDto auth, CommentRequest.DeleteComment request) {
        Comment currentComment = commentRepository.findById(request.commentId())
                .orElseThrow(() -> new CommentHandler(ErrorStatus.COMMENT_NOT_FOUND));

        // 임시 로직
        if (!currentComment.getMember().getId().equals(1L)) {
            throw new CommentHandler(ErrorStatus.COMMENT_NOT_AUTHOR_FORBIDDEN);
        }

        // TODO: 인증 객체 생성 필요
//        if (!currentComment.getMember().getId().equals(auth.id())) {
//            throw new CommentHandler(ErrorStatus.COMMENT_NOT_AUTHOR_FORBIDDEN);
//        }
        if (currentComment.getChildren() != null) {
            // 대댓글의 대댓글이 있을 가능성을 염두, 재귀함수로 구현
            currentComment.getChildren().forEach(this::deleteChildrenComment);
        }
        ResultResponse.CommentResult commentResult = commentConverter.toCommentResult(currentComment);
        commentRepository.deleteById(currentComment.getId());

        return commentResult;
    }

    private List<Image> createImages(List<MultipartFile> fileList, Gallery gallery) {
        List<Image> imageList = fileList.stream().map(file -> {
            Image image = imageConverter.toImage(file, amazonS3Manger, amazonConfig.getPostPath());
            image.setGallery(gallery);
            return image;
        }).toList();
        gallery.setImageList(imageConverter.toGalleryImageList(imageList));
        return imageList;
    }

    private void deleteImageFromS3(String url) {
        amazonS3Manger.deleteImageForS3(amazonS3Manger.extractImageKeyFromUrl(url));
    }

    private void deleteImageList(List<Image> deleteImageList) {
        imageRepository.deleteAll(deleteImageList);
    }

    private void deleteChildrenComment(Comment comment) {
        if (comment.getChildren() != null) {
            comment.getChildren().forEach(this::deleteChildrenComment);
        }
        commentRepository.delete(comment);
    }
}
