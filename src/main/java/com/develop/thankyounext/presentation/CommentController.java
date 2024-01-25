package com.develop.thankyounext.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

//TODO 모든 API Response, Parameter 수정 필요
@RestController
@RequestMapping("/api/comment")
@Tag(name = "댓글 API", description = "댓글 관련 API 입니다.")
public class CommentController {

    @PostMapping
    @Operation(
            description = "댓글 내용을 받아 생성합니다.",
            summary = "댓글 등록 API"
    )
    public void registerComment() {

    }

    @PatchMapping
    @Operation(
            description = "댓글 내용을 받아 수정합니다.",
            summary = "댓글 수정 API"
    )
    public void updateComment() {

    }

    @DeleteMapping
    @Operation(
            description = "댓글 ID를 받아 삭제합니다.",
            summary = "댓글 삭제 API"
    )
    public void deleteComment() {

    }
}
