package com.hanmaum.counseling.domain.post.controller;

import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.repository.LetterRepository;
import com.hanmaum.counseling.domain.post.service.LetterService;
import com.hanmaum.counseling.domain.post.service.ReplyService;
import com.hanmaum.counseling.security.CustomUserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"Posts"})
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class CounselController {
    private final LetterService letterService;
    private final ReplyService replyService;

    @ApiOperation("편지 작성")
    @PostMapping("/{postId}/letters")
    public ResponseEntity<String> writeLetter(@RequestBody @Valid FormDto form,
                                              @PathVariable("postId") Long postId,
                                              Authentication auth) {
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        letterService.writeLetter(form, postId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @ApiOperation("답장 작성")
    @PostMapping("/{postId}/letters/{letterId}")
    public ResponseEntity<String> writeReply(@RequestBody @Valid FormDto form,
                                              @PathVariable("postId") Long postId,
                                             @PathVariable("letterId") Long letterId,
                                              Authentication auth) {
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        replyService.writeReply(form, letterId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    //Todo 1. 상담 취소, 2. 상담 종료

}
