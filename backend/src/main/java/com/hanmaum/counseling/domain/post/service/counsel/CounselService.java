package com.hanmaum.counseling.domain.post.service.counsel;

import com.hanmaum.counseling.domain.post.dto.DetailCounselDto;
import com.hanmaum.counseling.domain.post.dto.MyCounselDto;
import com.hanmaum.counseling.domain.post.dto.UserStoryStateDto;

import java.util.List;

public interface CounselService {
    DetailCounselDto getDetailCounsel(Long counselId, Long userId);
    List<DetailCounselDto> getDetailCounsels(Long userId);
    List<UserStoryStateDto> getUserCounselState(Long userId);
    List<MyCounselDto> getMyCounselingList(Long userId);
    Long finishCounsel(Long counselId, Long userId);
    Long cancelCounsel(Long counselId, Long userId);
}
