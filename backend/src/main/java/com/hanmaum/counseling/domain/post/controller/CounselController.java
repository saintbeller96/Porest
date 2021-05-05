package com.hanmaum.counseling.domain.post.controller;

import com.hanmaum.counseling.domain.post.dto.DetailCounselDto;
import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.service.LetterService;
import com.hanmaum.counseling.domain.post.service.counsel.CounselService;
import com.hanmaum.counseling.security.CustomUserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Api(tags = {"Counsels"})
@RestController
@RequestMapping("/counsels")
@RequiredArgsConstructor
public class CounselController {
    private final LetterService letterService;
    private final CounselService counselService;

    @GetMapping("")
    public ResponseEntity<List<DetailCounselDto>> getDetailCounsels(Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        List<DetailCounselDto> result = counselService.getDetailCounsels(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{counselId}")
    public ResponseEntity<DetailCounselDto> getDetailCounsel(@PathVariable("counselId") Long counselId,
                                                                 Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        DetailCounselDto detailCounsel = counselService.getDetailCounsel(counselId, userId);
        return ResponseEntity.ok(detailCounsel);
    }
    //Todo 1. 상담 취소, 2. 상담 종료

}
