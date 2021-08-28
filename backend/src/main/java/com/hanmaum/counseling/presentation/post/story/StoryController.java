package com.hanmaum.counseling.presentation.post.story;

import com.hanmaum.counseling.domain.post.counsel.Counsel;
import com.hanmaum.counseling.domain.post.story.Story;
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
import java.util.stream.Collectors;

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
        List<Story> result = storyService.getStoriesOfUser(userId);
        return ResponseEntity.ok(result.stream()
                .map(UserStoryStateDto::of)
                .collect(Collectors.toList()));
    }

    @ApiOperation("해당 사연의 진행 중인 상담 목록 가져오기")
    @GetMapping("/{storyId}/counsels")
    public ResponseEntity<List<UserCounselStateDto>> getStory(@PathVariable("storyId") Long storyId, @LoginUserId Long userId){
        Story story = storyService.getStoryOfUser(storyId, userId);
        return ResponseEntity.ok(story.getCounsels().stream()
                .map(UserCounselStateDto::of)
                .collect(Collectors.toList()));
    }

    @ApiOperation("사연 등록")
    @PostMapping("")
    public ResponseEntity<?> putStory(@RequestBody @Valid FormDto formDto, @LoginUserId Long userId){
        storyService.putStory(formDto.getTitle(), formDto.getContent(), userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation("선택할 후보 사연들을 보여줌")
    @GetMapping("/candidates")
    public ResponseEntity<List<SimpleStoryDto>> getCandidates(@LoginUserId Long userId){
        List<Story> result = storyService.getCandidates(userId);
        return ResponseEntity.ok(result.stream()
                .map(SimpleStoryDto::of)
                .collect(Collectors.toList()));
    }

    @ApiOperation("후보 사연들 중 사연 선택")
    @PostMapping("/{storyId}")
    public ResponseEntity<SimpleCounselDto> pickStory(@PathVariable("storyId") Long storyId, @LoginUserId Long userId){
        Counsel pickedCounsel = storyService.pickStory(storyId, userId);
        return ResponseEntity.ok(SimpleCounselDto.of(pickedCounsel));
    }

    @ApiOperation("사연 삭제")
    @DeleteMapping("/{storyId}")
    public ResponseEntity<String> deleteStory(@PathVariable("storyId") Long storyId, @LoginUserId Long userId){
        storyService.deleteStory(storyId, userId);
        return ResponseEntity.noContent().build();
    }
}
