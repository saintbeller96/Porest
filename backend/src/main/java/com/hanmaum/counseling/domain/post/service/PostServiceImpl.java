package com.hanmaum.counseling.domain.post.service;

import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.entity.Letter;
import com.hanmaum.counseling.domain.post.entity.Story;
import com.hanmaum.counseling.domain.post.repository.LetterRepository;
import com.hanmaum.counseling.domain.post.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final StoryRepository storyRepository;
    private final LetterRepository letterRepository;

    @Override
    public List<SimpleStoryDto> getCandidates(Long userId) {

        return storyRepository.pickCandidates(userId);
    }

    @Override
    public Long saveStory(FormDto form, Long userId) {
        //1. 사연 생성
        Story story = new Story();

        //2. 편지 생성
        Letter letter = Letter.write(userId, form.getTitle(), form.getContent(), story);

        //3. 사연 저장
        storyRepository.save(story);

        //4. 편지 저장
        Letter saveLetter = letterRepository.save(letter);

        return saveLetter.getId();
    }
}
