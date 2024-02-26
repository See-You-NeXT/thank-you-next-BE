package com.develop.thankyounext.presentation;

import com.develop.thankyounext.domain.dto.result.ResultResponse.MemberResult;
import com.develop.thankyounext.global.payload.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.develop.thankyounext.domain.dto.member.MemberRequest.UpdateMember;
import static com.develop.thankyounext.domain.dto.member.MemberResponse.GetMember;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
@Tag(name = "사용자 API", description = "사용자 정보 관련 API 입니다.")
public class MemberController {

    @GetMapping("/profile")
    @Operation(
            description = "유저 정보를 조회합니다.",
            summary = "유저 정보 조회 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetMember> getProfile() {
        GetMember resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PatchMapping("/profile")
    @Operation(
            description = "유저 정보를 받아 수정합니다.",
            summary = "유저 정보 수정 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<MemberResult> updateProfile(
            @RequestBody final UpdateMember request
    ) {
        MemberResult resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }
}
