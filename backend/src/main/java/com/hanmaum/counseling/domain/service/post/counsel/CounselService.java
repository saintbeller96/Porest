package com.hanmaum.counseling.domain.service.post.counsel;

import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.model.post.counsel.Counsel;
import com.hanmaum.counseling.domain.model.post.story.Story;

import java.util.List;

public interface CounselService {

    Counsel connectCounsel(Story story, User user);
    Counsel getCounsel(Long counselId, Long userId);
    List<Counsel> getCounsels(Long userId);
    List<Counsel> getCounselsByCounsellor(Long counsellorId);
    Counsel finishCounsel(int score, boolean open, Long counselId, Long userId);
}
