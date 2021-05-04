package com.hanmaum.counseling.domain.account.controller;

import com.hanmaum.counseling.domain.account.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/profile-img")
    public ResponseEntity<?> updateProfileImg(MultipartFile image, HttpServletRequest request) {
        Map<String, Object> result = userService.updateProfileImg(image, request);
        return ResponseEntity.ok(result);
    }
}