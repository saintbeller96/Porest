package com.hanmaum.counseling.domain.post.service.story;

import com.hanmaum.counseling.domain.post.dto.DetailStoryDto;
import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.hanmaum.counseling.domain.post.dto.SimpleCounselDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.entity.Counsel;
import com.hanmaum.counseling.domain.post.entity.CounselStatus;
import com.hanmaum.counseling.domain.post.entity.Letter;
import com.hanmaum.counseling.domain.post.entity.Story;
import com.hanmaum.counseling.domain.post.repository.LetterRepository;
import com.hanmaum.counseling.domain.post.repository.post.CounselRepository;
import com.hanmaum.counseling.domain.post.repository.story.CounselContent;
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
        Counsel counsel = counselRepository.save(new Counsel(story, userId, CounselStatus.CONNECT));

        //최초의 편지는 사연의 내용을 그대로 작성
        Letter letter = Letter.builder()
                .writerId(story.getId())
                .content(story.getForm().getContent())
                .title(story.getForm().getTitle())
                .counsel(counsel)
                .build();

        //편지 저장
        Letter saveLetter = letterRepository.save(letter);

        //선택한 사연의 정보 반환
        return SimpleCounselDto.builder()
                .postId(counsel.getId())
                .letterId(saveLetter.getId())
                .title(saveLetter.getForm().getTitle())
                .content(saveLetter.getForm().getContent())
                .date(saveLetter.getCreatedAt())
                .build();
    }

    @Override
    public List<DetailStoryDto> getStory(Long storyId, Long userId) {
        List<CounselContent> counselContents = storyRepository.getStory(storyId, userId);
        List<DetailStoryDto> result = counselContents.stream()
                .collect(Collectors.groupingBy(pc -> pc.getCounselId()))
                .values().stream()
                .map(this::convertToDetailStory)
                .collect(Collectors.toList());
        return result;
    }

    private DetailStoryDto convertToDetailStory(List<CounselContent> pcList){
        DetailStoryDto result = new DetailStoryDto();
        Long counselId = null;
        for(CounselContent pc : pcList){
            counselId = pc.getCounselId();
            result.getDetail().add(LetterReplyDto.convert(pc));
        }
        result.setPostId(counselId);
        return result;
    }
}
