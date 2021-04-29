package com.hanmaum.counseling.domain.post.controller;

import com.hanmaum.counseling.domain.post.dto.SimplePostDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.service.story.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stories")
public class StoryController {
    private final StoryService storyService;

    @PostMapping("")
    public ResponseEntity<?> putStory(@RequestBody @Valid SimpleStoryDto storyDto, Authentication auth){
        Long userId = null;
        storyService.putStory(storyDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/candidates")
    public ResponseEntity<List<SimpleStoryDto>> getCandidates(Authentication auth){
        Long userId = null;
        List<SimpleStoryDto> result = storyService.getCandidates(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{storyId}")
    public ResponseEntity<SimplePostDto> pickStory(@PathVariable("storyId") Long storyId, Authentication auth){
        Long userId = null;
        SimplePostDto result = storyService.pickStory(userId, storyId);
        return ResponseEntity.ok(result);
    }
}
