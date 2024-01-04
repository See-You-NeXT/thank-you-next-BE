package com.develop.thankyounext.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

//TODO 모든 API Response, Parameter 수정 필요
@RestController
@RequestMapping("/api")
@Tag(name = "게시글 API", description = "게시글 관련 API 입니다.")
public class PostController {

    @GetMapping("/posts/{dtype}/search")
    @Operation(
            description = "게시글 타입, 검색어 타입, 검색어를 받아 게시글을 조회합니다.",
            summary = "게시글 검색조회 API"
    )
    public void getPostsByKeyword(@PathVariable String dtype, @RequestParam String type, @RequestParam String keyword) {

    }

    @GetMapping("/posts/{dtype}")
    @Operation(
            description = "게시글 타입을 받아 전체 게시글을 조회합니다.",
            summary = "게시글 다건조회 API"
    )
    public void getPosts(@PathVariable String dtype) {

    }

    @GetMapping("/posts/{postId}")
    @Operation(
            description = "게시글 ID를 받아 조회합니다.",
            summary = "게시글 단건조회 API"
    )
    public void getPost() {

    }

    @PostMapping("/post")
    @Operation(
            description = "게시글 타입, 제목, 내용, 첨부파일 리스트, 태그 리스트를 받아 생성합니다.",
            summary = "게시글 생성 API"
    )
    public void registerPost() {

    }

    @PatchMapping("/post")
    @Operation(
            description = "게시글 제목, 내용, 첨부파일 리스트, 태그 리스트를 받아 수정합니다.",
            summary = "게시글 수정 API"
    )
    public void updatePost() {

    }

    @DeleteMapping("/post")
    @Operation(
            description = "게시글 ID를 받아 삭제합니다.",
            summary = "게시글 삭제 API"
    )
    public void deletePost() {

    }

}
