package com.develop.thankyounext.application.module.etc.amazon.s3;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonS3ModuleService {

    // 이미지 업로드
    String uploadFileForS3(final String keyName, final MultipartFile file);

    // 이미지 Url로 Key 추출
    String extractImageKeyFromUrl(final String imageUrl);

    // 저장된 이미지 제거
    void deleteImageForS3(final String key);

    // 이미지 파일 경로로 저장
    String generateFilesKeyName(final String filePath);
}
