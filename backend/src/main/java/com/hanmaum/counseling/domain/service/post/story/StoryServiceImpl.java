package com.hanmaum.counseling.domain.service.post.story;

import com.hanmaum.counseling.commons.NicknameGenerateService;
import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.service.user.AccountService;
import com.hanmaum.counseling.domain.model.post.counsel.Counsel;
import com.hanmaum.counseling.domain.service.post.counsel.CounselService;
import com.hanmaum.counseling.domain.model.post.story.Story;
import com.hanmaum.counseling.domain.model.post.story.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService{

    private final StoryRepository storyRepository;
    private final AccountService accountService;
    private final CounselService counselService;

    @Override
    public Story putStory(String title, String content, Long userId) {
        User user = accountService.getUser(userId);
        Story story = Story.builder()
                .title(title)
                .content(content)
                .writerNickName(NicknameGenerateService.generateNegative())
                .writer(user)
                .build();
        return storyRepository.save(story);
    }

    @Override
    public List<Story> getCandidates(Long userId) {
        return storyRepository.getCandidates(userId);
    }

    @Override
    public Counsel pickStory(Long storyId, Long userId) {
        Story story = getStory(storyId);
        //사연의 주인공과 현재 유저를 연결
        User counsellor = accountService.getUser(userId);
        Counsel counsel = counselService.connectCounsel(story, counsellor);
        story.addCounsel(counsel);
        story.addPicked();
        return counsel;
    }

    @Override
    public List<Story> getStoriesOfUser(Long userId) {
        return storyRepository.findByWriterId(userId);
    }


    @Override
    public Story getStoryOfUser(Long storyId, Long userId) {
        Story story = getStory(storyId);
        story.validateUser(userId);
        return story;
    }

    @Override
    public Long deleteStory(Long storyId, Long userId) {
        Story story = getStory(storyId);
        story.validateUser(userId);
        storyRepository.delete(story);
        return storyId;
    }

    private Story getStory(Long storyId) {
        return storyRepository.findByIdFetch(storyId)
                .orElseThrow(IllegalStateException::new);
    }
}
