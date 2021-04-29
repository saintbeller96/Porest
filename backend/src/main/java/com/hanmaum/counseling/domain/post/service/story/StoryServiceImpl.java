package com.hanmaum.counseling.domain.post.service.story;

import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.hanmaum.counseling.domain.post.dto.SimplePostDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.entity.Letter;
import com.hanmaum.counseling.domain.post.entity.PostStatus;
import com.hanmaum.counseling.domain.post.entity.Posts;
import com.hanmaum.counseling.domain.post.entity.Story;
import com.hanmaum.counseling.domain.post.repository.LetterRepository;
import com.hanmaum.counseling.domain.post.repository.PostRepository;
import com.hanmaum.counseling.domain.post.repository.story.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService{

    private final StoryRepository storyRepository;
    private final PostRepository postRepository;
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
    public SimplePostDto pickStory(Long userId, Long storyId) {
        //사연 찾기
        Story story = storyRepository.findById(storyId).orElseThrow(
                ()->{throw new IllegalStateException();}
        );
        //사연의 주인공과 현재 유저를 연결
        Posts post = postRepository.save(new Posts(story, userId, PostStatus.CONNECT));

        //최초의 편지는 사연의 내용을 그대로 작성
        Letter letter = Letter.builder()
                .writerId(story.getId())
                .content(story.getForm().getContent())
                .title(story.getForm().getTitle())
                .post(post)
                .build();

        //편지 저장
        Letter saveLetter = letterRepository.save(letter);

        //선택한 사연의 정보 반환
        return SimplePostDto.builder()
                .postId(post.getId())
                .letterId(saveLetter.getId())
                .title(saveLetter.getForm().getTitle())
                .content(saveLetter.getForm().getContent())
                .date(saveLetter.getCreatedAt())
                .build();
    }

    @Override
    public List<LetterReplyDto> getStories(Long storyId, Long userId) {

        return null;
    }
}
