package com.develop.thankyounext.application;

import com.amazonaws.services.s3.AmazonS3;
import com.develop.thankyounext.global.config.aws.AmazonConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AmazonS3Service {
    private final AmazonS3 amazonS3;

    private final AmazonConfig amazonConfig;

//    public String uploadFile(final String keyName, final MultipartFile file) {
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentLength(file.getSize());
//        try{
//            amazonS3.putObject(new PutObjectRequest(amazonConfig.getBucket(), keyName, file.getInputStream(), metadata));
//        } catch (IOException e) {
//            log.error("파일을 업로드하는데 오류가 발생했습니다. : {}", (Object) e.getStackTrace());
//        }
//        return amazonS3.getUrl(amazonConfig.getBucket(), keyName).toString();
//    }
//
//    public String uploadImage(final String keyName, final MultipartFile file) {
//        String originName = file.getOriginalFilename();
//        String ext = originName.substring(originName.lastIndexOf(".")); //확장자
//
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentLength(file.getSize());
//        metadata.setContentType(file.getContentType()); //다운로드가 아닌 브라우저로 조회를 하기 위함
//        try{
//            amazonS3.putObject(new PutObjectRequest(amazonConfig.getBucket(), keyName + ext, file.getInputStream(), metadata)
//                    .withCannedAcl(CannedAccessControlList.PublicRead));
//        } catch (IOException e) {
//            log.error("파일을 업로드하는데 오류가 발생했습니다. : {}", (Object) e.getStackTrace());
//        }
//        return amazonS3.getUrl(amazonConfig.getBucket(), keyName + ext).toString();
//    }
//
//    public String generateMemberProfileKeyName() {
//        return amazonConfig.getMemberProfilePath() + '/' + UUID.randomUUID();
//    }
//
//    public String generatePostKeyName() {
//        return amazonConfig.getPostPath() + '/' + UUID.randomUUID();
//    }
}
