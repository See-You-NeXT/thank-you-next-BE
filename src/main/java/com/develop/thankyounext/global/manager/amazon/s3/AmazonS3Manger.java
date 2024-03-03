package com.develop.thankyounext.global.manager.amazon.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.develop.thankyounext.infrastructure.config.aws.AmazonConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class AmazonS3Manger {

    private final AmazonS3 amazonS3;

    private final AmazonConfig amazonConfig;

    public String uploadFileForS3(final String keyName, final MultipartFile file) {
        String originName = file.getOriginalFilename(); // 파일 이름
        String ext = originName != null ? originName.substring(originName.lastIndexOf(".")) : null; // 확장자

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType()); // 다운로드가 아닌 브라우저로 조회를 하기 위함

        try {
            amazonS3.putObject(new PutObjectRequest(amazonConfig.getBucket(), keyName + ext, file.getInputStream(), metadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            log.error("파일을 업로드하는데 오류가 발생했습니다. : {}", (Object) e.getStackTrace());
        }
        log.info("amazonS3.getUrl(amazonConfig.getBucket(), keyName + ext).toString(): {}", amazonS3.getUrl(amazonConfig.getBucket(), keyName + ext).toString());
        return amazonS3.getUrl(amazonConfig.getBucket(), keyName + ext).toString();
    }

    public String extractImageKeyFromUrl(final String imageUrl) {
        String bucket = amazonConfig.getBucket();
        String prefix = "https://" + bucket + ".s3." + amazonConfig.getRegion() + ".amazonaws.com/";
        return imageUrl.substring(prefix.length());
    }

    public void deleteImageForS3(final String key) {
        amazonS3.deleteObject(amazonConfig.getBucket(), key);
    }

    public String generateFilesKeyName(final String filePath) {
        return filePath + '/' + UUID.randomUUID();
    }
}
