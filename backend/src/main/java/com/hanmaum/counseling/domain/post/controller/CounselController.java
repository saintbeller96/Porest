package com.hanmaum.counseling.domain.post.controller;

import com.hanmaum.counseling.domain.post.dto.DetailCounselDto;
import com.hanmaum.counseling.domain.post.dto.MyCounselDto;
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

import java.util.List;

@Api(tags = {"Counsels"})
@RestController
@RequestMapping("/counsels")
@RequiredArgsConstructor
public class CounselController {
    private final CounselService counselService;

    @ApiOperation("현재 사용자의 모든 상담 내역을 반환")
    @GetMapping("")
    public ResponseEntity<List<DetailCounselDto>> getDetailCounsels(Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        List<DetailCounselDto> result = counselService.getDetailCounsels(userId);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("상담 ID로 현재 사용자의 상담 내역을 반환")
    @GetMapping("/{counselId}")
    public ResponseEntity<DetailCounselDto> getDetailCounsel(@PathVariable("counselId") Long counselId, Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        DetailCounselDto detailCounsel = counselService.getDetailCounsel(counselId, userId);
        return ResponseEntity.ok(detailCounsel);
    }

    @GetMapping("/counselings")
    public ResponseEntity<List<MyCounselDto>> getMyCounselList(Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        List<MyCounselDto> result = counselService.getMyCounselingList(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{counselId}")
    public ResponseEntity<String> finishCounsel(@PathVariable("counselId") Long counselId, Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        counselService.finishCounsel(counselId, userId);
        return ResponseEntity.ok("finish");
    }

    @PutMapping("/{counselId}")
    public ResponseEntity<String> cancelCounsel(@PathVariable("counselId") Long counselId, Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        //counselService.finishCounsel(counselId, userId);
        return ResponseEntity.ok("cancel");
    }

    @DeleteMapping("/{counselId")
    public ResponseEntity<String> deleteCounsel(@PathVariable("counselId") Long counselId, Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        //counselService.finishCounsel(counselId, userId);
        return ResponseEntity.ok("delete");
    }
}
