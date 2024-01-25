package com.develop.thankyounext.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

@Getter
public class UpdateMemberDTO {
    @NotBlank
    @Size(max = 50)
    private String password;
    @NotNull
    private String paswordCheck;
    @NotBlank
    @Size(max = 10)
    private String name;
    @NotNull
    @Size(min = 8, max = 8)
    private String studentId;
    private String description;
    private List<String> linkList;
}
