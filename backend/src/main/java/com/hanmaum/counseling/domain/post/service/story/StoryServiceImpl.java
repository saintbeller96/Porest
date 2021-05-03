package com.hanmaum.counseling.domain.post.service.story;

import com.hanmaum.counseling.commons.NicknameGenerator;
import com.hanmaum.counseling.domain.post.dto.*;
import com.hanmaum.counseling.domain.post.entity.*;
import com.hanmaum.counseling.domain.post.repository.LetterRepository;
import com.hanmaum.counseling.domain.post.repository.counsel.CounselRepository;
import com.hanmaum.counseling.domain.post.repository.story.CounselContent;
import com.hanmaum.counseling.domain.post.repository.story.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService{

    private final StoryRepository storyRepository;
    private final CounselRepository counselRepository;
    private final LetterRepository letterRepository;

    @Override
    public Long putStory(SimpleStoryDto storyDto, Long userId) {
        Story story = Story.builder()
                .isOpened(false)
                .title(storyDto.getDetail().getTitle())
                .content(storyDto.getDetail().getContent())
                .writerId(userId)
                .build();
        Story save = storyRepository.save(story);
        return save.getId();
    }

    @Override
    public List<SimpleStoryDto> getCandidates(Long userId) {
        return storyRepository.getCandidates(userId);
    }

    @Override
    public SimpleCounselDto pickStory(Long storyId, Long userId) {
        //사연 찾기
        Story story = storyRepository.findById(storyId).orElseThrow(
                ()->{throw new IllegalStateException();}
        );
        story.addPicked();
        //사연의 주인공과 현재 유저를 연결
        Counsel counsel = counselRepository.save(Counsel.createConnectedCounsel(story, userId));
        story.addCounsel(counsel);
        //최초의 편지는 사연의 내용을 그대로 작성
        Letter saveLetter = createFirstLetter(story, counsel);

        //선택한 사연의 정보 반환
        return SimpleCounselDto.create(counsel.getId(), saveLetter);
    }

    @Override
    public List<UserStoryInfoDto> getUserStoryInfo(Long userId) {
        List<Story> stories = storyRepository.findByWriterId(userId);
        List<UserStoryInfoDto> result = stories.stream()
                .map(this::mappingStory)
                .collect(Collectors.toList());
        return result;
    }

    private UserStoryInfoDto mappingStory(Story story){
        int cnt = 0;
        for(Counsel counsel : story.getCounsels()){
            int len = counsel.getLetters().size();
            Letter lastLetter = counsel.getLetters().get(len-1);
            if(lastLetter.getWriterId()!=story.getWriterId() && lastLetter.getStatus() == LetterStatus.READ){
                cnt++;
            }
        }
        return UserStoryInfoDto.getMyStoryInfo(story, cnt);
    }


    private Letter createFirstLetter(Story story, Counsel counsel) {
        //사연 생성
        Letter letter = Letter.builder()
                .writerId(story.getWriterId())
                .content(story.getForm().getContent())
                .title(story.getForm().getTitle())
                .status(LetterStatus.WAIT)
                .build();

        //편지 저장
        Letter saveLetter = letterRepository.save(letter);
        counsel.addLetter(saveLetter);
        return saveLetter;
    }

    @Override
    public List<DetailCounselDto> getStory(Long storyId, Long userId) {

        return null;
    }
}
