package com.develop.thankyounext.presentation;

import com.develop.thankyounext.global.payload.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.develop.thankyounext.domain.dto.auth.AuthRequest.Login;
import static com.develop.thankyounext.domain.dto.auth.AuthRequest.SignUp;
import static com.develop.thankyounext.domain.dto.result.ResultResponse.AuthResult;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "인증/인가 API", description = "회원 인증/인가 관련 API 입니다.")
public class AuthController {

    @PostMapping("/sign-up")
    @Operation(
            description = "회원 정보를 받아 가입합니다.",
            summary = "회원가입 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<AuthResult> signUp(
            @RequestBody SignUp request
    ) {
        AuthResult resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PostMapping("/login")
    @Operation(
            description = "이메일과 비밀번호를 받아 로그인합니다.",
            summary = "로그인 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<AuthResult> login(
            @RequestBody Login request
    ) {
        AuthResult resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }
}
