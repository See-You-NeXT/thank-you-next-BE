package com.develop.thankyounext.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRoleEnum {

    ADMIN(Authority.ADMIN),
    USER(Authority.USER),
    MENTOR(Authority.MENTOR);

    private final String authority;

    public static class Authority {
        public static final String USER = "ROLE_USER";
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String MENTOR = "ROLE_MENTOR";
    }
}
