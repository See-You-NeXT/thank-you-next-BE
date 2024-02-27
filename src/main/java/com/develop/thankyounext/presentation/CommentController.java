package com.develop.thankyounext.presentation;

import com.develop.thankyounext.application.command.entity.comment.CommentCommandService;
import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.DeleteComment;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.RegisterComment;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.UpdateComment;
import com.develop.thankyounext.global.payload.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static com.develop.thankyounext.domain.dto.result.ResultResponse.CommentResult;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts/{postId}/comment")
@Tag(name = "댓글 API", description = "댓글 관련 API 입니다.")
public class CommentController {

    private final CommentCommandService commentCommandService;

    @PostMapping
    @Operation(
            description = "댓글 내용을 받아 생성합니다.",
            summary = "댓글 등록 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<CommentResult> registerComment(
            @AuthenticationPrincipal final AuthenticationDto auth,
            @PathVariable final Long postId,
            @RequestBody final RegisterComment request
    ) {
        CommentResult resultDTO = commentCommandService.registerComment(auth, postId, request);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PatchMapping
    @Operation(
            description = "댓글 내용을 받아 수정합니다.",
            summary = "댓글 수정 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<CommentResult> updateComment(
            @AuthenticationPrincipal final AuthenticationDto auth,
            @PathVariable final Long postId,
            @RequestBody final UpdateComment request
    ) {
        CommentResult resultDTO = commentCommandService.updateComment(auth, postId, request);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @DeleteMapping
    @Operation(
            description = "댓글 ID를 받아 삭제합니다.",
            summary = "댓글 삭제 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<CommentResult> deleteComment(
            @AuthenticationPrincipal final AuthenticationDto auth,
            @PathVariable final Long postId,
            @RequestBody final DeleteComment request
    ) {
        CommentResult resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }
}
