package com.hanmaum.counseling.domain.post.service.counsel;

import com.hanmaum.counseling.domain.post.dto.DetailCounselDto;
import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.hanmaum.counseling.domain.post.dto.MyCounselDto;
import com.hanmaum.counseling.domain.post.dto.UserStoryStateDto;
import com.hanmaum.counseling.domain.post.entity.*;
import com.hanmaum.counseling.domain.post.repository.counsel.CounselRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService{

    private final CounselRepository counselRepository;

    @Override
    @Transactional(readOnly = true)
    public DetailCounselDto getDetailCounsel(Long counselId, Long userId) {
        Counsel counsel = getCounsel(counselId);
        //사연자와 상담사가 아니면 이 상담 내역에 접근 불가
        if(userId != counsel.getCounsellorId() && userId != counsel.getStory().getWriterId()){
            throw new IllegalStateException("This user is not affiliated with this counsel.");
        }

        return convertToDetailCounselDto(counsel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetailCounselDto> getDetailCounsels(Long userId) {
        List<Counsel> result = counselRepository.findByUserId(userId);
        return result.stream()
                .map(this::convertToDetailCounselDto)
                .collect(Collectors.toList());
    }

    private DetailCounselDto convertToDetailCounselDto(Counsel counsel) {
        List<Letter> letters = counsel.getLetters();
        DetailCounselDto result = new DetailCounselDto();
        result.setCounselId(counsel.getId());
        result.setCounsellorNickname(counsel.getCounsellorNickname());
        int len = letters.size();
        for(int i = 0; i+1<len; i+=2){
            Letter letter = letters.get(i);
            Letter reply = letters.get(i+1);
            result.getDetail().add(LetterReplyDto.of(letter, reply));
        }
        //현재 letters가 홀수이면 마지막 편지는 사연자의 편지
        if(len%2 == 1){
            Letter lastLetter = letters.get(len-1);
            result.getDetail().add(
                    LetterReplyDto.builder()
                    .letterTitle(lastLetter.getTitle())
                    .letterContent(lastLetter.getContent())
                    .letterDate(lastLetter.getCreatedAt())
                    .build());
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserStoryStateDto> getUserCounselState(Long userId) {
        List<Counsel> counsels = counselRepository.findByCounsellorId(userId);
        List<UserStoryStateDto> result = counsels.stream()
                .map(this::mappingToUserStoryStateDto)
                .collect(Collectors.toList());
        return result;
    }
    private UserStoryStateDto mappingToUserStoryStateDto(Counsel counsel){
        Story story = counsel.getStory();
        long count = counsel.getLetters().stream()
                .filter(letter ->
                        letter.getWriterId() == story.getWriterId()
                        && letter.getStatus() == LetterStatus.WAIT)
                .count();
        return UserStoryStateDto.getMyCounselInfo(story, counsel, (int)count);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MyCounselDto> getMyCounselingList(Long userId) {
        List<Counsel> counsels = counselRepository.findByCounsellorId(userId);
        return counsels.stream().map(this::mappingToMyCounselDto)
                .collect(Collectors.toList());
    }
    private MyCounselDto mappingToMyCounselDto(Counsel counsel){
        List<Letter> letters = counsel.getLetters();
        int len = letters.size();
        Letter last = letters.get(len-1);
        String title = last.getForm().getTitle();
        int num = 0;
        //마지막 편지를 쓴 사람이 상담원이 아니고 이 편지를 아직 읽지 않았다면 num을 증가
        if(last.getWriterId() != counsel.getCounsellorId() && last.getStatus() == LetterStatus.WAIT){
            num++;
        }
        return new MyCounselDto(counsel.getId(), counsel.getStory().getWriterNickName(), title, num);
    }

    @Override
    @Transactional
    public Long finishCounsel(Long counselId, Long userId) {
        Counsel counsel = getCounsel(counselId);
        validateUser(userId, counsel);
        counsel.setStatus(CounselStatus.END);
        return counselId;
    }

    @Override
    @Transactional
    public Long cancelCounsel(Long counselId, Long userId) {
        Counsel counsel = getCounsel(counselId);
        validateUser(userId, counsel);
        counsel.setStatus(CounselStatus.CANCEL);
        return counselId;
    }

    private Counsel getCounsel(Long counselId) {
        return counselRepository.findByCounselId(counselId)
                .orElseThrow(IllegalStateException::new);
    }

    private void validateUser(Long userId, Counsel counsel){
        if(userId != counsel.getStory().getWriterId()){
            throw new IllegalStateException("This user cannot modify this counsel");
        }
    }
}
