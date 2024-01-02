package com.develop.thankyounext.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "인증/인가 API", description = "회원 인증/인가 관련 API 입니다.")
public class AuthController {

    //TODO: 추후 Response, parameter 수정 필요
    @PostMapping("/sign-up")
    @Operation(
            description = "회원 정보를 받아 가입합니다.",
            summary = "회원가입 API"
    )
    public String signUp(String request){
        return "Sign Up Success!!";
    }

    //TODO: 추후 Response, parameter 수정 필요
    @PostMapping("/login")
    @Operation(
            description = "이메일과 비밀번호를 받아 로그인합니다.",
            summary = "로그인 API"
    )
    public String login(String request){
        return "Login Success!!";
    }
}
