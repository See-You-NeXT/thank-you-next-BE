package com.develop.thankyounext.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

//TODO 모든 API Response, Parameter 수정 필요
@RestController
@RequestMapping("/api/gallery")
@Tag(name = "갤러리 API", description = "갤러리 관련 API 입니다.")
public class GalleryController {
    @GetMapping("/{galleryId}")
    @Operation(
            description = "갤러리 ID를 받아 조회합니다.",
            summary = "갤러리 단건조회 API"
    )
    public void getGallery(@PathVariable Long galleryId) {

    }

    @GetMapping
    @Operation(
            description = "전체 갤러리를 조회합니다.",
            summary = "갤러리 다건조회 API"
    )
    public void getGalleries() {

    }

    @PostMapping
    @Operation(
            description = "갤러리 제목, 첨부파일 리스트를 받아 생성합니다.",
            summary = "갤러리 등록 API"
    )
    public void registerGallery() {

    }

    @PatchMapping
    @Operation(
            description = "갤러리 제목, 첨부파일 리스트를 받아 생성합니다.",
            summary = "갤러리 수정 API"
    )
    public void updateGallery() {

    }

    @DeleteMapping
    @Operation(
            description = "갤러리 ID를 받아 삭제합니다.",
            summary = "갤러리 삭제 API"
    )
    public void deleteGallery() {

    }
}
