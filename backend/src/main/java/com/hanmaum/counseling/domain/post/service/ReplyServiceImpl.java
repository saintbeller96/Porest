package com.hanmaum.counseling.domain.post.service;

import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.entity.Letter;
import com.hanmaum.counseling.domain.post.entity.Reply;
import com.hanmaum.counseling.domain.post.repository.LetterRepository;
import com.hanmaum.counseling.domain.post.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
    private final LetterRepository letterRepository;
    private final ReplyRepository replyRepository;

    @Override
    public Long writeReply(FormDto form, Long letterId, Long userId) {
        Letter letter = letterRepository.findById(letterId).orElseThrow(
                ()->{throw new IllegalStateException();}
        );

        Reply reply = Reply.builder()
                .letter(letter)
                .writerId(userId)
                .title(form.getTitle())
                .content(form.getContent())
                .build();

        Reply saveReply = replyRepository.save(reply);

        return saveReply.getId();
    }
}
