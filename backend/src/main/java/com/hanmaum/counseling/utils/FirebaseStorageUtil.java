package com.hanmaum.counseling.utils;

import com.google.cloud.storage.*;
import com.google.firebase.cloud.StorageClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log
public class FirebaseStorageUtil {

    private final FileUtil fileUtil;

    public String uploadUserProfileImage(MultipartFile multipartFile) throws IOException {

        //firebase storage
        StorageClient storageClient = StorageClient.getInstance();
        Storage storage = storageClient.bucket().getStorage();

        //파일
        File file = fileUtil.convertMultiPartToFile(multipartFile);
        Path filePath = file.toPath();

        //MIME 타입 확인
        log.info(Files.probeContentType(filePath));

        //firebase storage에 저장될 경로
        String fileName = fileUtil.generateFileName(multipartFile);

        //Metadata 생성
        UUID uuid = UUID.randomUUID();
        Map<String, String> metadata = new HashMap<>();
        metadata.put("firebaseStorageDownloadTokens", uuid.toString());


        //Blob 생성
        BlobId blobId = BlobId.of(storageClient.bucket().getName(), "images/profile/"+fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(Files.probeContentType(filePath))
                .setMetadata(metadata)
                .build();

        //storage에 파일 업로드
        Blob blob = storage.create(blobInfo, Files.readAllBytes(filePath));

        log.info("File " + filePath + " uploaded to bucket " + storageClient.bucket().getName() + " as " + fileName);

        return fileUtil.generateUrl(fileName, ImageType.PROFILE_IMG, uuid.toString());
    }
}
