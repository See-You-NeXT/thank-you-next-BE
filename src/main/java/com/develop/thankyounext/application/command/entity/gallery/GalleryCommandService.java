package com.develop.thankyounext.application.command.entity.gallery;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.comment.CommentRequest;
import com.develop.thankyounext.domain.dto.gallery.GalleryRequest;
import com.develop.thankyounext.domain.dto.gallery.GalleryRequest.RegisterGallery;
import com.develop.thankyounext.domain.dto.result.ResultResponse;
import com.develop.thankyounext.domain.dto.result.ResultResponse.GalleryResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GalleryCommandService {
    GalleryResult registerGallery(AuthenticationDto auth, RegisterGallery request, List<MultipartFile> fileList);

    GalleryResult updateGallery(AuthenticationDto auth, GalleryRequest.UpdateGallery request, List<MultipartFile> fileList);

    GalleryResult deleteGallery(AuthenticationDto auth, GalleryRequest.DeleteGallery request);

    ResultResponse.CommentResult registerComment(AuthenticationDto auth, Long galleryId, CommentRequest.RegisterComment request);
}
