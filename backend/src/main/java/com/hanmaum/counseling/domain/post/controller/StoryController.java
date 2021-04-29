package com.hanmaum.counseling.domain.post.controller;

import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.service.StoryService;
import com.hanmaum.counseling.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
        Long userId = ((CustomUserDetails)auth.getPrincipal()).getId();
        storyService.putStory(storyDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/candidates")
    public ResponseEntity<List<SimpleStoryDto>> getCandidates(Authentication auth){
        Long userId = null;
        List<SimpleStoryDto> result = storyService.showStories(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{storyId}")
    public ResponseEntity<SimpleStoryDto> pickStory(@PathVariable("storyId") Long storyId, Authentication auth){
        Long userId = null;
        SimpleStoryDto result = storyService.pickStory(userId, storyId);
        return ResponseEntity.ok(result);
    }
}
