package com.develop.thankyounext.global.exception.handler;

import com.develop.thankyounext.global.exception.GeneralException;
import com.develop.thankyounext.global.payload.code.BaseErrorCode;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode code) {
        super(code);
    }
}
