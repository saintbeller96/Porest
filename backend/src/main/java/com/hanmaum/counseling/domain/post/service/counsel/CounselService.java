package com.hanmaum.counseling.domain.post.service.counsel;

import com.hanmaum.counseling.domain.post.dto.DetailCounselDto;
import com.hanmaum.counseling.domain.post.dto.EvaluateDto;
import com.hanmaum.counseling.domain.post.dto.UserCounselStateDto;
import com.hanmaum.counseling.domain.post.dto.UserStoryStateDto;

import java.util.List;

public interface CounselService {
    /**
     * 해당 상담의 상세 내역 반환
     * @param counselId
     * @param userId
     * @return
     */
    DetailCounselDto getDetailCounsel(Long counselId, Long userId);

    /**
     * 유저가 상담해준 모든 상세 내역 반환
     * @param userId
     * @return
     */
    List<DetailCounselDto> getDetailCounsels(Long userId);

    /**
     * 유저가 상담사이고, 상담해준 내역들의 상태를 반환
     * @param userId
     * @return
     */
    List<UserCounselStateDto> getCounselStateOfUser(Long userId);

    Long finishCounsel(EvaluateDto evaluate, Long counselId, Long userId);
}
