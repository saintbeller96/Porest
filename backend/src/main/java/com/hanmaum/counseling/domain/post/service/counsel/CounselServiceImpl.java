package com.hanmaum.counseling.domain.post.service.counsel;

import com.hanmaum.counseling.domain.post.dto.DetailCounselDto;
import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.hanmaum.counseling.domain.post.dto.UserStoryInfoDto;
import com.hanmaum.counseling.domain.post.entity.Counsel;
import com.hanmaum.counseling.domain.post.entity.Letter;
import com.hanmaum.counseling.domain.post.entity.LetterStatus;
import com.hanmaum.counseling.domain.post.entity.Story;
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

        Counsel counsel = counselRepository.findByCounselId(counselId)
                .orElseThrow(IllegalStateException::new);

        List<Letter> letters = counsel.getLetters();
        DetailCounselDto result = new DetailCounselDto();

        int len = letters.size();
        for(int i = 0; i+1<len; i+=2){
            Letter letter = letters.get(i);
            Letter reply = letters.get(i+1);
            result.getDetail().add(LetterReplyDto.of(letter, reply));
        }
        //현재 letters가 홀수개이면 마지막 편지는 사연자의 편지
        if(len%2 == 1){
            Letter lastLetter = letters.get(len-1);
            result.getDetail().add(
                    LetterReplyDto.builder()
                    .letterTitle(lastLetter.getForm().getTitle())
                    .letterContent(lastLetter.getForm().getContent())
                    .letterDate(lastLetter.getCreatedAt())
                    .build());
        }

        return result;
    }

    @Override
    public List<UserStoryInfoDto> getUserCounselInfo(Long userId) {
        List<Counsel> counsels = counselRepository.findByCounsellorId(userId);
        List<UserStoryInfoDto> result = counsels.stream()
                .map(this::mapping)
                .collect(Collectors.toList());
        return result;
    }

    public UserStoryInfoDto mapping(Counsel counsel){
        Story story = counsel.getStory();
        long count = counsel.getLetters().stream()
                .filter(letter ->
                        letter.getWriterId() == story.getWriterId()
                        && letter.getStatus() == LetterStatus.WAIT)
                .count();
        return UserStoryInfoDto.getMyCounselInfo(story, counsel, (int)count);
    }
}
