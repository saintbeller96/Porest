package com.hanmaum.counseling.domain.post.service.story;

import com.hanmaum.counseling.domain.post.dto.*;
import com.hanmaum.counseling.domain.post.entity.*;
import com.hanmaum.counseling.domain.post.repository.LetterRepository;
import com.hanmaum.counseling.domain.post.repository.counsel.CounselRepository;
import com.hanmaum.counseling.domain.post.repository.story.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService{

    private final StoryRepository storyRepository;
    private final CounselRepository counselRepository;
    private final LetterRepository letterRepository;

    @Override
    public Long putStory(FormDto formDto, Long userId) {
        Story story = Story.builder()
                .title(formDto.getTitle())
                .content(formDto.getContent())
                .writerId(userId)
                .build();
        return storyRepository.save(story).getId();
    }

    @Override
    public List<SimpleStoryDto> getCandidates(Long userId) {
        return storyRepository.getCandidates(userId);
    }

    @Override
    public SimpleCounselDto pickStory(Long storyId, Long userId) {
        //사연 찾기
        Story story = getStory(storyId);
        story.addPicked();
        //사연의 주인공과 현재 유저를 연결
        Counsel counsel = counselRepository.save(Counsel.createConnectedCounsel(story, userId));
        story.addCounsel(counsel);
        //최초의 편지는 사연의 내용을 그대로 작성
        Letter saveLetter = createFirstLetter(story, counsel);
        //편지 저장
        counsel.addLetter(saveLetter);
        letterRepository.save(saveLetter);

        //선택한 사연의 정보 반환
        return SimpleCounselDto.create(counsel.getId(), saveLetter);
    }

    @Override
    public List<UserStoryStateDto> getUserStoryState(Long userId) {
        List<Story> stories = storyRepository.findByWriterId(userId);
        List<UserStoryStateDto> result = stories.stream()
                .map(this::mappingToUserStoryStateDto)
                .collect(Collectors.toList());
        return result;
    }

    private UserStoryStateDto mappingToUserStoryStateDto(Story story){
        int cnt = 0;
        for(Counsel counsel : story.getCounsels()){
            int len = counsel.getLetters().size();
            Letter lastLetter = counsel.getLetters().get(len-1);

            if(lastLetter.getWriterId()!=story.getWriterId() && lastLetter.getStatus() == LetterStatus.WAIT){
                cnt++;
            }
        }
        return UserStoryStateDto.getMyStoryInfo(story, cnt);
    }

    private Letter createFirstLetter(Story story, Counsel counsel) {
        //사연 생성
        Letter letter = Letter.builder()
                .writerId(story.getWriterId())
                .content(story.getForm().getContent())
                .title(story.getForm().getTitle())
                .status(LetterStatus.READ)
                .build();
        return letter;
    }

    @Override
    public List<UserCounselStateDto> getCounselStateOfUserWithStory(Long storyId, Long userId) {
        Story story = getStory(storyId);
        if(story.getWriterId() != userId){
            throw new IllegalStateException("해당 사용자는 이 사연의 상담 내역에 접근할 권한이 없습니다");
        }
        return story.getCounsels().stream()
                .filter(counsel -> counsel.getStatus() == CounselStatus.CONNECT)
                .map(this::mappingToUserCounselStateDto)
                .collect(Collectors.toList());
    }

    private UserCounselStateDto mappingToUserCounselStateDto(Counsel counsel) {
        List<Letter> letters = counsel.getLetters();
        int len = letters.size();
        Letter last = letters.get(len-1);
        int num = 0;
        //상담사가 해준 마지막 답장을 last에 저장
        //해당 답장이 읽지 않은 상태이면 num 증가
        for(Letter letter : letters){
            if(letter.getWriterId() == counsel.getCounsellorId()){
                last = letter;
                if(last.getStatus() == LetterStatus.WAIT){
                    num++;
                }
            }
        }
        return new UserCounselStateDto(counsel.getId(), counsel.getCounsellorNickname(), last.getTitle(), num, last.getCreatedAt());
    }

    @Override
    public Long deleteStory(Long storyId, Long userId) {
        Story story = getStory(storyId);
        if(story.getWriterId() != userId)
            throw new IllegalStateException("이 유저는 사연을 삭제할 권한이 없습니다.");
        if(story.getCounsels().size() == 0){
            throw new IllegalStateException("상담이 진행 중인 사연은 삭제가 불가합니다.");
        }
        storyRepository.delete(story);
        return storyId;
    }

    private Story getStory(Long storyId) {
        return storyRepository.findByIdFetch(storyId).orElseThrow(IllegalStateException::new);
    }
}
