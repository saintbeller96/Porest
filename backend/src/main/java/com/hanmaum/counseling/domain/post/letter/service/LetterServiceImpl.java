package com.hanmaum.counseling.domain.post.letter.service;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.account.service.AccountService;
import com.hanmaum.counseling.domain.post.counsel.service.CounselService;
import com.hanmaum.counseling.presentation.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.counsel.Counsel;
import com.hanmaum.counseling.domain.post.letter.Letter;
import com.hanmaum.counseling.domain.post.letter.LetterStatus;
import com.hanmaum.counseling.domain.post.letter.repository.LetterRepository;
import com.hanmaum.counseling.domain.post.counsel.repository.CounselRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LetterServiceImpl implements LetterService{
    private final LetterRepository letterRepository;
    private final CounselService counselService;
    private final AccountService accountService;

    @Override
    public Letter writeLetter(String title, String content, Long counselId, Long prevLetterId, Long userId) {
        Counsel counsel = counselService.getCounsel(counselId, userId);
        User writer = accountService.getUser(userId);
        Letter prevLetter = getLetter(prevLetterId);

        Letter letter = Letter.builder()
                .writer(writer)
                .prevLetter(prevLetter)
                .title(title)
                .content(content)
                .status(LetterStatus.WAIT)
                .build();
        counsel.addLetter(letter);
        return letterRepository.save(letter);
    }

    @Override
    public Letter readLetter(Long letterId, Long userId) {
        Letter letter = getLetter(letterId);
        letter.read(userId);
        return letter;
    }

    private Letter getLetter(Long letterId) {
        Letter letter = letterRepository.findByIdFetch(letterId)
                .orElseThrow(IllegalStateException::new);
        return letter;
    }
}
