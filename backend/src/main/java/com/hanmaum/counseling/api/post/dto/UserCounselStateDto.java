package com.hanmaum.counseling.api.post.dto;

import com.hanmaum.counseling.domain.model.post.counsel.Counsel;
import com.hanmaum.counseling.domain.model.post.letter.Letter;
import com.hanmaum.counseling.domain.model.post.letter.LetterStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class UserCounselStateDto {
    private Long counselId;
    private String writerNickname;
    private String title;
    private int numOfReplies;
    private LocalDateTime updatedAt;

    @Builder
    public UserCounselStateDto(Long counselId, String writerNickname, String title, int numOfReplies, LocalDateTime updatedAt) {
        this.counselId = counselId;
        this.writerNickname = writerNickname;
        this.title = title;
        this.numOfReplies = numOfReplies;
        this.updatedAt = updatedAt;
    }

    public static UserCounselStateDto of(Counsel counsel) {
        List<Letter> letters = counsel.getLetters();
        int len = letters.size();
        Letter last = letters.get(len-1);
        int num = 0;
        //마지막 편지를 쓴 사람이 사연의 주인공이고 이 편지를 아직 읽지 않았다면 num을 증가
        for(Letter letter : letters){
            if(letter.getWriter().getId() == counsel.getStory().getWriter().getId()){
                last = letter;
                if(last.getStatus() == LetterStatus.WAIT){
                    num++;
                }
            }
        }
        return UserCounselStateDto.builder()
                .counselId(counsel.getId())
                .writerNickname(counsel.getCounsellorNickname())
                .title(last.getTitle())
                .numOfReplies(num)
                .updatedAt(last.getCreatedAt())
                .build();
    }
}
