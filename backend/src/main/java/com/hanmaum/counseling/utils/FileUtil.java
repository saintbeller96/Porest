package com.hanmaum.counseling.utils;

import com.google.firebase.cloud.StorageClient;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Service
public class FileUtil {
    static final String PREFIX = "https://firebasestorage.googleapis.com/v0/b/";
    static final String SUFFIX = "?alt=media&token=";
    static final String IMG_PATH = "src/main/resources/images/";

    public File convertMultiPartToFile(MultipartFile file) throws IOException {

        //파일 경로가 없다면 생성
        mkdir();
        File convertedFile = new File(IMG_PATH + Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(file.getBytes());
        fos.close();
        return convertedFile;
    }

    public String generateFileName(MultipartFile multiPart) {
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        sb.append(date.getTime()).append("-").append(multiPart.getOriginalFilename().replace(" ", "_"));
        return sb.toString();
    }

    public String generateUrl(String fileName, ImageType type, String uuid) {
        StringBuilder sb = new StringBuilder();
        switch (type){
            case PROFILE_IMG:
                sb      .append(PREFIX)
                        .append(StorageClient.getInstance().bucket().getName())
                        .append("/o/images%2Fprofile%2F")
                        .append(fileName)
                        .append(SUFFIX)
                        .append(uuid);
                break;
                //만약에 다른 곳에서 사진을 등록한다면 수정해야 함(디폴트로 사용해도 좋을 듯)
            case OTHER_IMG:
                sb      .append(PREFIX)
                        .append(StorageClient.getInstance().bucket().getName())
                        .append("/o/images%2Fother%2F")
                        .append(fileName)
                        .append(SUFFIX)
                        .append(uuid);
                break;
            default:
                break;
        }
        return sb.toString();
    }

    private void mkdir() {
        File Folder = new File(IMG_PATH);

        // 해당 디렉토리가 없을경우 디렉토리를 생성
        if (!Folder.exists()) {
            try{
                Folder.mkdir();
            }
            catch(Exception e){ e.getStackTrace();}
        }
    }
}
