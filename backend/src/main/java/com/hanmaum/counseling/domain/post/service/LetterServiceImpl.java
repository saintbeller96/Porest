package com.hanmaum.counseling.domain.post.service;

import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.entity.Counsel;
import com.hanmaum.counseling.domain.post.entity.Letter;
import com.hanmaum.counseling.domain.post.repository.LetterRepository;
import com.hanmaum.counseling.domain.post.repository.counsel.CounselRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LetterServiceImpl implements LetterService{
    private final LetterRepository letterRepository;
    private final CounselRepository counselRepository;

    @Override
    public Long writeLetter(FormDto form, Long counselId, Long parentLetterId, Long userId) {
        Counsel counsel = counselRepository.findById(counselId).orElseThrow(
                ()->{throw new IllegalStateException();}
        );

        Letter letter = Letter.builder()
                .writerId(userId)
                .content(form.getContent())
                .title(form.getTitle())
                .counsel(counsel)
                .build();

        Letter saveLetter = letterRepository.save(letter);
        return saveLetter.getId();
    }
}
