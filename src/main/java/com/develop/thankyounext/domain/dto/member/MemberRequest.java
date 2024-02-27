package com.develop.thankyounext.domain.dto.member;

import com.develop.thankyounext.domain.embedded.LinkUrlList;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MemberRequest {

    public record UpdateMember(
            @NotBlank
            @Size(max = 50)
            String password,
            @NotBlank
            String passwordCheck,
            @NotBlank
            @Size(max = 10)
            String name,
            @NotBlank
            @Size(min = 8, max = 8)
            String studentId,
            String description,
            LinkUrlList linkUrlList
    ) {
    }
}
