package com.hanmaum.counseling.api.post.letter;

import com.hanmaum.counseling.api.argumentresolver.LoginUserId;
import com.hanmaum.counseling.api.post.dto.FormDto;
import com.hanmaum.counseling.domain.service.post.letter.LetterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = {"Letters"})
@RestController
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    @ApiOperation("편지 작성")
    @PostMapping("/counsels/{counselId}/letters/{letterId}")
    public ResponseEntity<String> writeLetter(@RequestBody @Valid FormDto form,
                                              @PathVariable("counselId") Long counselId,
                                              @PathVariable("letterId") Long letterId,
                                              @LoginUserId Long userId) {
        letterService.writeLetter(form.getTitle(), form.getContent(), counselId, letterId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @ApiOperation("편지 읽음")
    @PostMapping("/counsels/{counselId}/letters/{letterId}/read")
    public ResponseEntity<String> readLetter(@PathVariable("counselId") Long counselId,
                                             @PathVariable("letterId") Long letterId,
                                             @LoginUserId Long userId) {
        letterService.readLetter(letterId, userId);
        return ResponseEntity.ok("Read Letter");
    }
}
