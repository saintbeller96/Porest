package com.hanmaum.counseling.domain.post.service;

import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.entity.Counsel;
import com.hanmaum.counseling.domain.post.entity.Letter;
import com.hanmaum.counseling.domain.post.entity.LetterStatus;
import com.hanmaum.counseling.domain.post.repository.LetterRepository;
import com.hanmaum.counseling.domain.post.repository.counsel.CounselRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LetterServiceImpl implements LetterService{
    private final LetterRepository letterRepository;
    private final CounselRepository counselRepository;

    @Override
    public Long writeLetter(FormDto form, Long counselId, Long parentLetterId, Long userId) {
        Counsel counsel = counselRepository.findById(counselId).orElseThrow(
                IllegalStateException::new
        );
        Letter parentLetter = getLetter(parentLetterId);

        Letter letter = Letter.write(userId, parentLetter, form.getTitle(), form.getContent());
        counsel.addLetter(letter);
        Letter saveLetter = letterRepository.save(letter);
        return saveLetter.getId();
    }

    @Override
    public Long readLetter(Long letterId, Long userId) {
        Letter letter = getLetter(letterId);
        if(letter.getParentLetter() == null){
            if(userId == letter.getCounsel().getCounsellorId()){
                letter.setStatus(LetterStatus.READ);
            }
        }else{
            if(letter.getParentLetter().getWriterId() == userId){
                letter.setStatus(LetterStatus.READ);
            }
        }
        return letter.getId();
    }

    private Letter getLetter(Long parentLetterId) {
        Letter letter = letterRepository.findByIdFetch(parentLetterId).orElseThrow(
                IllegalStateException::new
        );
        return letter;
    }
}
