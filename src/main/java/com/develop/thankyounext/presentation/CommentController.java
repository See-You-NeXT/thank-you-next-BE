package com.develop.thankyounext.presentation;

import com.develop.thankyounext.application.comment.command.CommentCommandService;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.DeleteCommentDTO;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.RegisterCommentDTO;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.UpdateCommentDTO;
import com.develop.thankyounext.global.api_payload.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.develop.thankyounext.domain.dto.result.ResultResponse.CommentResultDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
@Tag(name = "댓글 API", description = "댓글 관련 API 입니다.")
public class CommentController {

//    private final CommentCommandService commentCommandService;

    @PostMapping
    @Operation(
            description = "댓글 내용을 받아 생성합니다.",
            summary = "댓글 등록 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<CommentResultDTO> registerComment(
            @RequestBody RegisterCommentDTO request
            ) {
        CommentResultDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PatchMapping
    @Operation(
            description = "댓글 내용을 받아 수정합니다.",
            summary = "댓글 수정 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<CommentResultDTO> updateComment(
            @RequestBody UpdateCommentDTO request
            ) {
        CommentResultDTO resultDTO = null;
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
    public ApiResponseDTO<CommentResultDTO> deleteComment(
            @RequestBody DeleteCommentDTO request
    ) {
        CommentResultDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }
}
