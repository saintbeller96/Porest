package com.hanmaum.counseling.domain.post.controller;

import com.hanmaum.counseling.domain.post.dto.*;
import com.hanmaum.counseling.domain.post.service.counsel.CounselService;
import com.hanmaum.counseling.domain.post.service.story.StoryService;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Api(tags = {"Stories"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/stories")
@Slf4j
public class StoryController {
    private final StoryService storyService;

    @ApiOperation("유저의 사연 목록 가져오기")
    @GetMapping("")
    public ResponseEntity<List<UserStoryStateDto>> getStories(Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        List<UserStoryStateDto> result = storyService.getUserStoryState(userId);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("사연에 대해 진행 중인 상담 목록 가져오기")
    @GetMapping("/{storyId}/counsels")
    public ResponseEntity<List<UserCounselStateDto>> getStory(@PathVariable("storyId") Long storyId, Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        List<UserCounselStateDto> result = storyService.getCounselStateOfUserWithStory(storyId, userId);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("사연 등록")
    @PostMapping("")
    public ResponseEntity<?> putStory(@RequestBody @Valid FormDto formDto, Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        storyService.putStory(formDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation("선택할 후보 사연들을 보여줌")
    @GetMapping("/candidates")
    public ResponseEntity<List<SimpleStoryDto>> getCandidates(Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        List<SimpleStoryDto> result = storyService.getCandidates(userId);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("후보 사연들 중 사연 선택")
    @PostMapping("/{storyId}")
    public ResponseEntity<SimpleCounselDto> pickStory(@PathVariable("storyId") Long storyId, Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        SimpleCounselDto result = storyService.pickStory(storyId, userId);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("사연 삭제")
    @DeleteMapping("/{storyId}")
    public ResponseEntity<String> deleteStory(@PathVariable("storyId") Long storyId, Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        storyService.deleteStory(storyId, userId);
        return ResponseEntity.noContent().build();
    }
    //Todo 사연 공개/비공개 설정
}
