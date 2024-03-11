package com.develop.thankyounext.global.exception.handler;

import com.develop.thankyounext.global.exception.GeneralException;
import com.develop.thankyounext.global.payload.code.BaseErrorCode;

public class GalleryHandler extends GeneralException {
    public GalleryHandler(BaseErrorCode code) {
        super(code);
    }
}
