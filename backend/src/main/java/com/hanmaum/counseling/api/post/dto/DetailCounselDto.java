package com.hanmaum.counseling.api.post.dto;

import com.hanmaum.counseling.domain.model.post.counsel.Counsel;
import com.hanmaum.counseling.domain.model.post.letter.Letter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class DetailCounselDto {
    private Long counselId;
    private String counsellorNickname;
    private List<LetterReplyDto> detail;

    public DetailCounselDto(Long counselId, String nickname){
        detail = new ArrayList<>();
        this.counselId = counselId;
        this.counsellorNickname = nickname;
    }

    public static DetailCounselDto of(Counsel counsel) {
        List<Letter> letters = counsel.getLetters();
        DetailCounselDto result = new DetailCounselDto(counsel.getId(), counsel.getCounsellorNickname());
        int len = letters.size();
        for(int i = 0; i+1<len; i+=2){
            Letter letter = letters.get(i);
            Letter reply = letters.get(i+1);
            result.getDetail().add(LetterReplyDto.of(letter, reply));
        }
        //현재 letters가 홀수이면 마지막 편지는 사연자의 편지
        if(len%2 == 1){
            Letter lastLetter = letters.get(len-1);
            result.getDetail().add(LetterReplyDto.builder().letter(lastLetter).build());
        }
        return result;
    }
}
