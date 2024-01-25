package com.develop.thankyounext.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostEnum {

    NOTICE(PostRole.NOTICE),
    QUESTION(PostRole.QUESTION),
    FREE(PostRole.FREE);

    private final String dType;

    public static class PostRole {
        public static final String NOTICE = "ROLE_NOTICE";
        public static final String QUESTION = "ROLE_QUESTION";
        public static final String FREE = "ROLE_FREE";
    }
}
