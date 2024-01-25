package com.develop.thankyounext.domain.dto.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class MemberRequest {

    public record UpdateMemberDTO(
            @NotBlank
            @Size(max = 50)
            String password,
            @NotBlank
            String paswordCheck,
            @NotBlank
            @Size(max = 10)
            String name,
            @NotBlank
            @Size(min = 8, max = 8)
            String studentId,
            String description,
            List<String> linkList
    ) {
    }
}
