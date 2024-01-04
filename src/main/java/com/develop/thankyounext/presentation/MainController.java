package com.develop.thankyounext.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/main")
@Tag(name = "메인 페이지 API", description = "메인 페이지 관련 API 입니다.")
public class MainController {

    @GetMapping("/banner")
    @Operation(
            description = "메인 페이지의 배너를 조회합니다.",
            summary = "배너 조회 API"
    )
    public void getBanner() {

    }

    @GetMapping("/promotion")
    @Operation(
            description = "메인 페이지의 홍보 영상을 조회합니다.",
            summary = "홍보 영상 조회 API"
    )
    public void getPromotion() {

    }
}
