package com.hanmaum.counseling.domain.post.service.counsel;

import com.hanmaum.counseling.domain.post.dto.DetailCounselDto;
import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.hanmaum.counseling.domain.post.dto.UserStoryInfoDto;

import java.util.List;

public interface CounselService {
    DetailCounselDto getDetailCounsel(Long counselId, Long userId);
    List<DetailCounselDto> getDetailCounsels(Long userId);
    List<UserStoryInfoDto> getUserCounselInfo(Long userId);
    void finishCounsel(Long counselId, Long userId);
}
