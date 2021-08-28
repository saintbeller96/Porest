package com.hanmaum.counseling.presentation.emotion;

import com.hanmaum.counseling.domain.emotion.Emotion;
import com.hanmaum.counseling.presentation.argumentresolver.LoginUserId;
import com.hanmaum.counseling.presentation.emotion.dto.EmotionCondition;
import com.hanmaum.counseling.presentation.emotion.dto.EmotionDetailDto;
import com.hanmaum.counseling.presentation.emotion.dto.EmotionSimpleDto;
import com.hanmaum.counseling.domain.emotion.service.EmotionService;
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

@Api(tags = {"Emotions"})
@RequestMapping("/emotions")
@RestController
@RequiredArgsConstructor
@Slf4j
public class EmotionController {
    private final EmotionService emotionService;

    @ApiOperation("감정 기록 등록")
    @PostMapping("")
    public ResponseEntity<String> createEmotion(@RequestBody @Valid EmotionDetailDto dto, @LoginUserId Long userId){
        emotionService.saveEmotion(dto.getFeeling(), dto.getContent(), dto.getImageUrl(), userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation("Id를 통해 감정 기록 가져오기")
    @GetMapping("/{emotionId}")
    public ResponseEntity<EmotionDetailDto> getEmotionDetail(@PathVariable("emotionId") Long emotionId, @LoginUserId Long userId){
        Emotion emotion = emotionService.getEmotion(emotionId, userId);
        return ResponseEntity.ok(EmotionDetailDto.of(emotion));
    }

    @ApiOperation("감정 기록 수정")
    @PutMapping("/{emotionId}")
    public ResponseEntity<String> updateEmotion(@RequestBody @Valid EmotionDetailDto dto,
                                                          @PathVariable("emotionId") Long emotionId, @LoginUserId Long userId){
        emotionService.updateEmotion(dto.getFeeling(), dto.getContent(), dto.getImageUrl(), emotionId, userId);
        return ResponseEntity.ok("Updated");
    }

    @ApiOperation("감정 기록 삭제")
    @DeleteMapping("/{emotionId}")
    public ResponseEntity<String> deleteEmotionDetail(@PathVariable("emotionId") Long emotionId, @LoginUserId Long userId){
        emotionService.deleteEmotion(emotionId, userId);
        return ResponseEntity.ok("delete");
    }

    @ApiOperation("년도/월 조건에 따라 해당 달의 모든 감정 기록을 가져오기")
    @GetMapping("")
    public ResponseEntity<List<EmotionSimpleDto>> searchEmotionByCondition(@Valid EmotionCondition condition, @LoginUserId Long userId){
        List<Emotion> result = emotionService.searchEmotion(condition, userId);
        return ResponseEntity.ok(result.stream()
                .map(EmotionSimpleDto::of)
                .collect(Collectors.toList()));
    }

}
