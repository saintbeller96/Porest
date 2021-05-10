package com.hanmaum.counseling.domain.account.controller;

import com.hanmaum.counseling.domain.account.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/profile-img")
    public ResponseEntity<?> updateProfileImg(MultipartFile image, HttpServletRequest request) {
        Map<String, Object> result = userService.updateProfileImg(image, request);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/profileImg/{imgNumber}")
    public ResponseEntity<?> updateProfileImgNumber(@PathVariable Long imgNumber, HttpServletRequest request){
        userService.updateProfileImgNumber(imgNumber, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}