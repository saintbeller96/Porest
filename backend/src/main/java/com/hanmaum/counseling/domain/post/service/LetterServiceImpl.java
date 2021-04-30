package com.hanmaum.counseling.domain.post.service;

import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.entity.Letter;
import com.hanmaum.counseling.domain.post.entity.Posts;
import com.hanmaum.counseling.domain.post.repository.LetterRepository;
import com.hanmaum.counseling.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LetterServiceImpl implements LetterService{
    private final LetterRepository letterRepository;
    private final PostRepository postRepository;

    @Override
    public Long writeLetter(FormDto form, Long postId, Long userId) {
        Posts post = postRepository.findById(postId).orElseThrow(
                ()->{throw new IllegalStateException();}
        );

        Letter letter = Letter.builder()
                .writerId(userId)
                .content(form.getContent())
                .title(form.getTitle())
                .post(post)
                .build();

        Letter saveLetter = letterRepository.save(letter);
        return saveLetter.getId();
    }
}
