package com.develop.thankyounext.presentation;

import com.develop.thankyounext.application.gallery.command.GalleryCommandService;
import com.develop.thankyounext.application.gallery.query.GalleryQueryService;
import com.develop.thankyounext.domain.dto.gallery.GalleryRequest.DeleteGalleryDTO;
import com.develop.thankyounext.domain.dto.gallery.GalleryRequest.RegisterGalleryDTO;
import com.develop.thankyounext.domain.dto.gallery.GalleryRequest.UpdateGalleryDTO;
import com.develop.thankyounext.global.api_payload.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.develop.thankyounext.domain.dto.gallery.GalleryResponse.GetGalleryDTO;
import static com.develop.thankyounext.domain.dto.gallery.GalleryResponse.GetGalleryListDTO;
import static com.develop.thankyounext.domain.dto.result.ResultResponse.GalleryResultDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gallery")
@Tag(name = "갤러리 API", description = "갤러리 관련 API 입니다.")
public class GalleryController {

//    private final GalleryCommandService galleryCommandService;
//    private final GalleryQueryService galleryQueryService;

    @GetMapping("/{galleryId}")
    @Operation(
            description = "갤러리 ID를 받아 조회합니다.",
            summary = "갤러리 단건조회 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetGalleryDTO> getGallery(
            @PathVariable Long galleryId
    ) {
        GetGalleryDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @GetMapping
    @Operation(
            description = "전체 갤러리를 조회합니다.",
            summary = "갤러리 다건조회 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetGalleryListDTO> getGalleries(
    ) {
        GetGalleryListDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PostMapping
    @Operation(
            description = "갤러리 제목, 첨부파일 리스트를 받아 생성합니다.",
            summary = "갤러리 등록 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GalleryResultDTO> registerGallery(
            @RequestPart RegisterGalleryDTO request,
            @RequestPart List<MultipartFile> imageList
    ) {
        GalleryResultDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PatchMapping
    @Operation(
            description = "갤러리 제목, 첨부파일 리스트를 받아 수정합니다.",
            summary = "갤러리 수정 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GalleryResultDTO> updateGallery(
            @RequestPart UpdateGalleryDTO request,
            @RequestPart List<MultipartFile> imageList
    ) {
        GalleryResultDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @DeleteMapping
    @Operation(
            description = "갤러리 ID를 받아 삭제합니다.",
            summary = "갤러리 삭제 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GalleryResultDTO> deleteGallery(
            @RequestBody DeleteGalleryDTO request
    ) {
        GalleryResultDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }
}
