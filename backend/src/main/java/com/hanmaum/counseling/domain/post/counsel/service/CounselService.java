package com.hanmaum.counseling.domain.post.counsel.service;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.post.counsel.Counsel;
import com.hanmaum.counseling.domain.post.story.Story;
import com.hanmaum.counseling.presentation.post.dto.DetailCounselDto;
import com.hanmaum.counseling.presentation.post.dto.EvaluateDto;
import com.hanmaum.counseling.presentation.post.dto.UserCounselStateDto;

import java.util.List;

public interface CounselService {

    Counsel connectCounsel(Story story, User user);
    Counsel getCounsel(Long counselId, Long userId);
    List<Counsel> getCounsels(Long userId);
    List<Counsel> getCounselsByCounsellor(Long counsellorId);
    Counsel finishCounsel(int score, boolean open, Long counselId, Long userId);
}
