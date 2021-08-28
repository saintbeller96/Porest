package com.hanmaum.counseling.presentation.post.dto;

import com.hanmaum.counseling.domain.post.counsel.Counsel;
import com.hanmaum.counseling.domain.post.letter.Letter;
import com.hanmaum.counseling.domain.post.letter.LetterStatus;
import com.hanmaum.counseling.domain.post.story.Story;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
public class UserStoryStateDto {
    private Long storyId;
    private String title;
    private LocalDateTime createdAt;
    private int numOfNewReply;
    private String nickname;

    @Builder
    public UserStoryStateDto(Long storyId, String title, LocalDateTime createdAt, int numOfNewReply, String nickname) {
        this.storyId = storyId;
        this.title = title;
        this.createdAt = createdAt;
        this.numOfNewReply = numOfNewReply;
        this.nickname = nickname;
    }

    public static UserStoryStateDto of(Story story) {
        int cnt = 0;
        for(Counsel counsel : story.getCounsels()){
            int len = counsel.getLetters().size();
            Letter lastLetter = counsel.getLetters().get(len-1);
            if(lastLetter.getWriter().equals(story.getWriter()) && lastLetter.getStatus() == LetterStatus.WAIT){
                cnt++;
            }
        }
        return UserStoryStateDto.builder()
                .storyId(story.getId())
                .title(story.getForm().getTitle())
                .createdAt(story.getCreatedAt())
                .numOfNewReply(cnt)
                .build();
    }
}
