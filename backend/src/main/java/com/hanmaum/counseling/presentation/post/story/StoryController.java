package com.hanmaum.counseling.presentation.post.story;

import com.hanmaum.counseling.presentation.argumentresolver.LoginUserId;
import com.hanmaum.counseling.presentation.post.dto.*;
import com.hanmaum.counseling.domain.post.story.service.StoryService;
import com.hanmaum.counseling.security.CustomUserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = {"Stories"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/stories")
@Slf4j
public class StoryController {
    private final StoryService storyService;

    @ApiOperation("유저의 사연 목록 가져오기")
    @GetMapping("")
    public ResponseEntity<List<UserStoryStateDto>> getStories(@LoginUserId Long userId){
        List<UserStoryStateDto> result = storyService.getUserStoryState(userId);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("해당 사연의 진행 중인 상담 목록 가져오기")
    @GetMapping("/{storyId}/counsels")
    public ResponseEntity<List<UserCounselStateDto>> getStory(@PathVariable("storyId") Long storyId, @LoginUserId Long userId){
        List<UserCounselStateDto> result = storyService.getCounselStateOfUserWithStory(storyId, userId);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("사연 등록")
    @PostMapping("")
    public ResponseEntity<?> putStory(@RequestBody @Valid FormDto formDto, @LoginUserId Long userId){
        storyService.putStory(formDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation("선택할 후보 사연들을 보여줌")
    @GetMapping("/candidates")
    public ResponseEntity<List<SimpleStoryDto>> getCandidates(@LoginUserId Long userId){
        List<SimpleStoryDto> result = storyService.getCandidates(userId);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("후보 사연들 중 사연 선택")
    @PostMapping("/{storyId}")
    public ResponseEntity<SimpleCounselDto> pickStory(@PathVariable("storyId") Long storyId, @LoginUserId Long userId){
        SimpleCounselDto result = storyService.pickStory(storyId, userId);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("사연 삭제")
    @DeleteMapping("/{storyId}")
    public ResponseEntity<String> deleteStory(@PathVariable("storyId") Long storyId, @LoginUserId Long userId){
        storyService.deleteStory(storyId, userId);
        return ResponseEntity.noContent().build();
    }
}
