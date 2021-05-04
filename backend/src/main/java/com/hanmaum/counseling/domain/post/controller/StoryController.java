package com.hanmaum.counseling.domain.post.controller;

import com.hanmaum.counseling.domain.post.dto.DetailCounselDto;
import com.hanmaum.counseling.domain.post.dto.SimpleCounselDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.dto.UserStoryInfoDto;
import com.hanmaum.counseling.domain.post.service.counsel.CounselService;
import com.hanmaum.counseling.domain.post.service.story.StoryService;
import com.hanmaum.counseling.security.CustomUserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
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
public class StoryController {
    private final StoryService storyService;
    private final CounselService counselService;

    @ApiOperation("유저의 사연/유저가 답변한 사연 가져오기")
    @GetMapping("")
    public ResponseEntity<Map<String, List<UserStoryInfoDto>>> putStory(Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        List<UserStoryInfoDto> s = storyService.getUserStoryInfo(userId);
        List<UserStoryInfoDto> c = counselService.getUserCounselInfo(userId);
        Map<String, List<UserStoryInfoDto>> response = new ConcurrentHashMap<>();
        response.put("my-letter-reply", s);
        response.put("other-letter-reply", c);
        return ResponseEntity.ok(response);
    }

    @ApiOperation("사연 등록")
    @PostMapping("")
    public ResponseEntity<?> putStory(@RequestBody @Valid SimpleStoryDto storyDto, Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        storyService.putStory(storyDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation("선택할 후보 사연들을 보여줌")
    @GetMapping("/candidates")
    public ResponseEntity<List<SimpleStoryDto>> getCandidates(Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        List<SimpleStoryDto> result = storyService.getCandidates(userId);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("사연 선택")
    @PostMapping("/{storyId}")
    public ResponseEntity<SimpleCounselDto> pickStory(@PathVariable("storyId") Long storyId, Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        SimpleCounselDto result = storyService.pickStory(storyId, userId);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("사연과 관련된 모든 편지-답장을 가져옴")
    @GetMapping("/{storyId}")
    public ResponseEntity<List<DetailCounselDto>> getStory(@PathVariable("storyId") Long storyId, Authentication auth){
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        List<DetailCounselDto> result = storyService.getStory(storyId, userId);
        return ResponseEntity.ok(result);
    }

    //Todo 사연 삭제, 사연 공개/비공개 설정
}
