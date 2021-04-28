package com.hanmaum.counseling.domain.post.service;

import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.entity.Story;
import com.hanmaum.counseling.domain.post.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService{

    private final StoryRepository storyRepository;

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
    public List<SimpleStoryDto> showStories(Long userId) {
        return storyRepository.getCandidates(userId);
    }

    @Override
    public SimpleStoryDto pickStory(Long storyId) {
        SimpleStoryDto result = storyRepository.pickOne(storyId).orElseThrow(
                ()->{throw new IllegalStateException();}
        );
        return result;
    }
}
