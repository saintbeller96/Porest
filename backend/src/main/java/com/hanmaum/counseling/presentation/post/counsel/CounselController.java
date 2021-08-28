package com.hanmaum.counseling.presentation.post.counsel;

import com.hanmaum.counseling.domain.post.counsel.Counsel;
import com.hanmaum.counseling.domain.post.counsel.CounselStatus;
import com.hanmaum.counseling.presentation.argumentresolver.LoginUserId;
import com.hanmaum.counseling.presentation.post.dto.DetailCounselDto;
import com.hanmaum.counseling.presentation.post.dto.EvaluateDto;
import com.hanmaum.counseling.presentation.post.dto.UserCounselStateDto;
import com.hanmaum.counseling.domain.post.counsel.service.CounselService;
import com.hanmaum.counseling.security.CustomUserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = {"Counsels"})
@RestController
@RequestMapping("/counsels")
@RequiredArgsConstructor
public class CounselController {
    private final CounselService counselService;

    @ApiOperation("현재 사용자의 모든(진행 끝난 것도 포함) 상담 내역을 반환")
    @GetMapping("/all")
    public ResponseEntity<List<DetailCounselDto>> getDetailCounsels(@LoginUserId Long userId){
        List<Counsel> result = counselService.getCounsels(userId);
        return ResponseEntity.ok(result.stream()
                .map(DetailCounselDto::of)
                .collect(Collectors.toList()));
    }

    @ApiOperation("상담 ID로 현재 사용자의 상담 내역을 반환")
    @GetMapping("/{counselId}")
    public ResponseEntity<DetailCounselDto> getDetailCounsel(@PathVariable("counselId") Long counselId, @LoginUserId Long userId){
        Counsel counsel = counselService.getCounsel(counselId, userId);
        return ResponseEntity.ok(DetailCounselDto.of(counsel));
    }

    @ApiOperation("현재 사용자가 진행중인 상담 내역 반환")
    @GetMapping("")
    public ResponseEntity<List<UserCounselStateDto>> getCounselList(@LoginUserId Long userId){
        List<Counsel> counsels = counselService.getCounselsByCounsellor(userId);
        return ResponseEntity.ok(counsels.stream()
                .filter(counsel -> counsel.getStatus() == CounselStatus.CONNECT)
                .map(UserCounselStateDto::of)
                .collect(Collectors.toList()));
    }

    @ApiOperation("상담 완료")
    @PostMapping("/{counselId}/finish")
    public ResponseEntity<String> finishCounsel(@PathVariable("counselId") Long counselId,
                                                @RequestBody @Valid EvaluateDto evaluateDto,
                                                @LoginUserId Long userId){
        counselService.finishCounsel(evaluateDto.getEvaluate().getScore(), evaluateDto.isOpen(), counselId, userId);
        return ResponseEntity.ok("finish");
    }
}
