package com.develop.thankyounext.presentation;

import com.develop.thankyounext.application.command.entity.post.PostCommandService;
import com.develop.thankyounext.application.query.entity.post.PostQueryService;
import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.post.PostRequest.DeletePost;
import com.develop.thankyounext.domain.dto.post.PostRequest.RegisterPost;
import com.develop.thankyounext.domain.dto.post.PostRequest.UpdatePost;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPostList;
import com.develop.thankyounext.domain.dto.result.ResultResponse.PostResult;
import com.develop.thankyounext.global.payload.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.develop.thankyounext.domain.dto.post.PostResponse.GetPost;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "게시글 API", description = "게시글 관련 API 입니다.")
public class PostController {

    private final PostCommandService postCommandService;
    private final PostQueryService postQueryService;

    @GetMapping("/posts")
    @Operation(
            description = "게시글 타입, 검색어 타입, 검색어를 받아 게시글을 조회합니다.",
            summary = "게시글 검색조회 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetPostList> getPostsByKeyword(
            @RequestParam final String dtype,
            @RequestParam(required = false) final String type,
            @RequestParam(required = false) final String keyword
    ) {
        GetPostList resultDTO = null;
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
    public ApiResponseDTO<GetPost> getPost(
            @AuthenticationPrincipal final AuthenticationDto auth,
            @PathVariable final Long postId
    ) {
        GetPost resultDTO = postQueryService.getPost(auth, postId);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PostMapping(value = "/post", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            description = "게시글 타입, 제목, 내용, 첨부파일 리스트, 태그 리스트를 받아 생성합니다.",
            summary = "게시글 등록 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<PostResult> registerPost(
            @AuthenticationPrincipal final AuthenticationDto auth,
            @RequestPart final RegisterPost request,
            @RequestPart final List<MultipartFile> fileList
    ) {
        PostResult resultDTO = postCommandService.registerPost(auth, request, fileList);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PatchMapping("/post")
    @Operation(
            description = "게시글 제목, 내용, 첨부파일 리스트, 태그 리스트를 받아 수정합니다.",
            summary = "게시글 수정 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<PostResult> updatePost(
            @RequestPart final UpdatePost request,
            @RequestPart final List<MultipartFile> fileList
    ) {
        PostResult resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @DeleteMapping("/post")
    @Operation(
            description = "게시글 ID를 받아 삭제합니다.",
            summary = "게시글 삭제 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<PostResult> deletePost(
            @RequestBody final DeletePost request
    ) {
        PostResult resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }
}
