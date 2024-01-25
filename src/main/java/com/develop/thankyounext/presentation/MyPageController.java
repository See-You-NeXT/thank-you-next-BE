package com.develop.thankyounext.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/my-page")
@Tag(name = "마이 페이지 API", description = "마이 페이지 관련 API 입니다.")
public class MyPageController {

    @GetMapping("/profile")
    @Operation(
            description = "유저 정보를 조회합니다.",
            summary = "유저 정보 조회 API"
    )
    public void getProfile() {

    }

    @PatchMapping("/profile")
    @Operation(
            description = "유저 정보를 받아 수정합니다.",
            summary = "유저 정보 수정 API"
    )
    public void updateProfile() {

    }
}
