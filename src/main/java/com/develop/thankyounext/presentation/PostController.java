package com.develop.thankyounext.presentation;

import com.develop.thankyounext.application.post.command.PostCommandService;
import com.develop.thankyounext.application.post.query.PostQueryService;
import com.develop.thankyounext.domain.dto.post.PostRequest.DeletePostDTO;
import com.develop.thankyounext.domain.dto.post.PostRequest.RegisterPostDTO;
import com.develop.thankyounext.domain.dto.post.PostRequest.UpdatePostDTO;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPostDTO;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPostListDTO;
import com.develop.thankyounext.domain.dto.result.ResultResponse.PostResultDTO;
import com.develop.thankyounext.global.api_payload.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "게시글 API", description = "게시글 관련 API 입니다.")
public class PostController {

    private final PostQueryService postQueryService;
    private final PostCommandService postCommandService;

    @GetMapping("/posts/{dtype}")
    @Operation(
            description = "게시글 타입, 검색어 타입, 검색어를 받아 게시글을 조회합니다.",
            summary = "게시글 검색조회 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetPostListDTO> getPostsByKeyword(
            @PathVariable final String dtype,
            @RequestParam final String type,
            @RequestParam final String keyword
    ) {
        GetPostListDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @GetMapping("/posts/{postId}")
    @Operation(
            description = "게시글 ID를 받아 조회합니다.",
            summary = "게시글 단건조회 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetPostDTO> getPost(
            @PathVariable final String postId
    ) {
        GetPostDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PostMapping("/post")
    @Operation(
            description = "게시글 타입, 제목, 내용, 첨부파일 리스트, 태그 리스트를 받아 생성합니다.",
            summary = "게시글 생성 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<PostResultDTO> registerPost(
            @RequestPart RegisterPostDTO request,
            @RequestPart List<MultipartFile> fileList
    ) {
        PostResultDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PatchMapping("/post")
    @Operation(
            description = "게시글 제목, 내용, 첨부파일 리스트, 태그 리스트를 받아 수정합니다.",
            summary = "게시글 수정 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<PostResultDTO> updatePost(
            @RequestPart UpdatePostDTO request,
            @RequestPart List<MultipartFile> fileList
    ) {
        PostResultDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @DeleteMapping("/post")
    @Operation(
            description = "게시글 ID를 받아 삭제합니다.",
            summary = "게시글 삭제 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<PostResultDTO> deletePost(
            @RequestBody DeletePostDTO request
            ) {
        PostResultDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }
}
