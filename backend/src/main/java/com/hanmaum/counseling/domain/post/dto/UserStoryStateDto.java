package com.hanmaum.counseling.domain.post.dto;

import com.hanmaum.counseling.domain.post.entity.Counsel;
import com.hanmaum.counseling.domain.post.entity.Story;
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

    public static UserStoryStateDto getMyStoryInfo(Story story, int numOfNewReply){
        return UserStoryStateDto.builder()
                .storyId(story.getId())
                .title(story.getForm().getTitle())
                .createdAt(story.getCreatedAt())
                .numOfNewReply(numOfNewReply)
                .build();
    }

    public static UserStoryStateDto getMyCounselInfo(Story story, Counsel counsel, int numOfNewReply){
        return UserStoryStateDto.builder()
                .storyId(story.getId())
                .title(story.getForm().getTitle())
                .createdAt(story.getCreatedAt())
                .numOfNewReply(numOfNewReply)
                .nickname(counsel.getCounsellorNickname())
                .build();
    }
}
