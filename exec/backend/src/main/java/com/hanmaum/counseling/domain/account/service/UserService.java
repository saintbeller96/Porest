package com.hanmaum.counseling.domain.account.service;

import com.hanmaum.counseling.domain.account.dto.UpdatePasswordDto;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.global.GlobalExceptionController;
import com.hanmaum.counseling.security.JwtProvider;
import com.hanmaum.counseling.utils.FirebaseStorageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log
public class UserService {
    private final FirebaseStorageUtil firebaseStorageUtil;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    //TODO : 이미지 변경 로직이 변경되면서 삭제 예정
    public Map<String, Object> updateProfileImg(MultipartFile multipartFile, HttpServletRequest request){

        //authorization header 가지고오기
        String token = request.getHeader("Authorization");
        token = token.substring(7);
        String email = jwtProvider.getEmailFromToken(token);

        //파일 업로드
        String fileName = null;
        try {
            fileName = firebaseStorageUtil.uploadUserProfileImage(multipartFile);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        //사용자 정보 update
        User user = userRepository.findByEmail(email).orElseThrow(IllegalStateException::new);
        user.setProfileImg(fileName);
        userRepository.save(user);

        Map<String, Object> result  = new HashMap<>();
        result.put("profileImg",fileName);
        return result;
    }

    public void updateProfileImgNumber(Long imgNumber, HttpServletRequest request) {
        //사용자 정보 update
        //authorization header 가지고오기
        String token = request.getHeader("Authorization").substring(7);
        String email = jwtProvider.getEmailFromToken(token);

        User user = userRepository.findByEmail(email).orElseThrow(IllegalStateException::new);
        user.setProfileImgNumber(imgNumber);
        userRepository.save(user);

    }
}
