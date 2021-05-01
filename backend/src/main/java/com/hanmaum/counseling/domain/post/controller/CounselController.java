package com.hanmaum.counseling.domain.post.controller;

import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.service.LetterService;
import com.hanmaum.counseling.security.CustomUserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"Counsels"})
@RestController
@RequestMapping("/counsels")
@RequiredArgsConstructor
public class CounselController {
    private final LetterService letterService;

    @ApiOperation("편지 작성")
    @PostMapping("/{counselId}/letters/{letterId}")
    public ResponseEntity<String> writeLetter(@RequestBody @Valid FormDto form,
                                              @PathVariable("counselId") Long counselId,
                                             @PathVariable("letterId") Long letterId,
                                              Authentication auth) {
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        letterService.writeLetter(form, counselId, letterId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    //Todo 1. 상담 취소, 2. 상담 종료

}
