package com.develop.thankyounext.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {
    GUEST("ROLE_GUEST"),
    MEMBER("ROLE_MEMBER");

    private final String key;
}
