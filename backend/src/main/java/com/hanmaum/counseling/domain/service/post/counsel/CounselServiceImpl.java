package com.hanmaum.counseling.domain.service.post.counsel;

import com.hanmaum.counseling.commons.NicknameGenerateService;
import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.service.user.AccountService;
import com.hanmaum.counseling.domain.model.post.counsel.Counsel;
import com.hanmaum.counseling.domain.model.post.counsel.CounselStatus;
import com.hanmaum.counseling.domain.model.post.letter.Letter;
import com.hanmaum.counseling.domain.model.post.letter.LetterStatus;
import com.hanmaum.counseling.domain.model.post.story.Story;
import com.hanmaum.counseling.domain.model.post.counsel.CounselRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService{

    private final CounselRepository counselRepository;
    private final AccountService accountService;

    @Override
    @Transactional
    public Counsel connectCounsel(Story story, User counsellor) {
        Counsel counsel = Counsel.builder()
                .counsellor(counsellor)
                .story(story)
                .counsellorNickname(NicknameGenerateService.generatePositive())
                .status(CounselStatus.CONNECT)
                .build();
        Letter first = Letter.builder()
                .title(story.getTitle())
                .content(story.getContent())
                .writer(story.getWriter())
                .status(LetterStatus.READ)
                .build();
        counsel.addLetter(first);
        return counselRepository.save(counsel);
    }

    @Override
    public Counsel getCounsel(Long counselId, Long userId) {
        Counsel counsel = getCounsel(counselId);
        //사연자와 상담사가 아니면 이 상담 내역에 접근 불가
        counsel.validateUser(userId);
        return counsel;
    }

    @Override
    public List<Counsel> getCounsels(Long userId) {
        return counselRepository.findByUserId(userId);
    }

    @Override
    public List<Counsel> getCounselsByCounsellor(Long counsellorId) {
        return counselRepository.findByCounsellorId(counsellorId);
    }

    @Override
    @Transactional
    public Counsel finishCounsel(int score, boolean open, Long counselId, Long userId) {
        Counsel counsel = getCounsel(counselId);
        counsel.validateUser(userId);
        counsel.finish(score, open);
        return counsel;
    }

    private Counsel getCounsel(Long counselId) {
        return counselRepository.findByCounselId(counselId)
                .orElseThrow(IllegalStateException::new);
    }
}
