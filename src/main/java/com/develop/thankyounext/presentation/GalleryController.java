package com.develop.thankyounext.presentation;

import com.develop.thankyounext.application.command.entity.gallery.GalleryCommandService;
import com.develop.thankyounext.application.query.entity.gallery.GalleryQueryService;
import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.comment.CommentRequest;
import com.develop.thankyounext.domain.dto.gallery.GalleryRequest.RegisterGallery;
import com.develop.thankyounext.domain.dto.gallery.GalleryResponse.GetGallery;
import com.develop.thankyounext.domain.dto.gallery.GalleryResponse.GetGalleryList;
import com.develop.thankyounext.domain.dto.result.ResultResponse;
import com.develop.thankyounext.global.payload.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.develop.thankyounext.domain.dto.gallery.GalleryRequest.DeleteGallery;
import static com.develop.thankyounext.domain.dto.gallery.GalleryRequest.UpdateGallery;
import static com.develop.thankyounext.domain.dto.result.ResultResponse.GalleryResult;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gallery")
@Tag(name = "갤러리 API", description = "갤러리 관련 API 입니다.")
public class GalleryController {

    private final GalleryCommandService galleryCommandService;

    private final GalleryQueryService galleryQueryService;

    @GetMapping("/{galleryId}")
    @Operation(
            description = "갤러리 ID를 받아 조회합니다.",
            summary = "갤러리 단건조회 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetGallery> getGallery(
            @PathVariable Long galleryId
    ) {
        GetGallery resultDTO = galleryQueryService.getGallery(galleryId);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @GetMapping
    @Operation(
            description = "전체 갤러리를 조회합니다.",
            summary = "갤러리 다건조회 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetGalleryList> getGalleries(
            @PageableDefault Pageable pageable
    ) {
        GetGalleryList resultDTO = galleryQueryService.getGalleryList(pageable);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PostMapping(path = "/admin", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            description = "갤러리 제목, 첨부파일 리스트를 받아 생성합니다.",
            summary = "갤러리 등록 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GalleryResult> registerGallery(
            @AuthenticationPrincipal AuthenticationDto auth,
            @RequestPart RegisterGallery request,
            @RequestPart List<MultipartFile> fileList
    ) {
        GalleryResult resultDTO = galleryCommandService.registerGallery(auth, request, fileList);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PatchMapping("/admin")
    @Operation(
            description = "갤러리 제목, 첨부파일 리스트를 받아 수정합니다.",
            summary = "갤러리 수정 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GalleryResult> updateGallery(
            @AuthenticationPrincipal AuthenticationDto auth,
            @RequestPart final UpdateGallery request,
            @RequestPart final List<MultipartFile> fileList
    ) {
        GalleryResult resultDTO = galleryCommandService.updateGallery(auth, request, fileList);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @DeleteMapping("/admin")
    @Operation(
            description = "갤러리 ID를 받아 삭제합니다.",
            summary = "갤러리 삭제 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GalleryResult> deleteGallery(
            @AuthenticationPrincipal AuthenticationDto auth,
            @RequestBody final DeleteGallery request
    ) {
        GalleryResult resultDTO = galleryCommandService.deleteGallery(auth, request);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PostMapping("/comment/{galleryId}")
    @Operation(
            description = "갤러리 댓글을 받아 저장합니다.",
            summary = "갤러리 댓글 등록 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<ResultResponse.CommentResult> registerComment(
            @AuthenticationPrincipal AuthenticationDto auth,
            @PathVariable final Long galleryId,
            @RequestBody final CommentRequest.RegisterComment request
    ) {
        ResultResponse.CommentResult resultDTO = galleryCommandService.registerComment(auth, galleryId, request);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PatchMapping("/comment")
    @Operation(
            description = "갤러리 댓글을 받아 수정합니다.",
            summary = "갤러리 댓글 수정 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<ResultResponse.CommentResult> updateComment(
            @AuthenticationPrincipal AuthenticationDto auth,
            @RequestBody final CommentRequest.UpdateComment request
    ) {
        ResultResponse.CommentResult resultDTO = galleryCommandService.updateComment(auth, request);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @DeleteMapping("/comment")
    @Operation(
            description = "갤러리 댓글을 받아 삭제합니다.",
            summary = "갤러리 댓글 삭제 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<ResultResponse.CommentResult> updateComment(
            @AuthenticationPrincipal AuthenticationDto auth,
            @RequestBody final CommentRequest.DeleteComment request
    ) {
        ResultResponse.CommentResult resultDTO = galleryCommandService.deleteComment(auth, request);
        return ApiResponseDTO.onSuccess(resultDTO);
    }
}
