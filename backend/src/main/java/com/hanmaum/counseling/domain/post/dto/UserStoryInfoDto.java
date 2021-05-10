package com.hanmaum.counseling.domain.post.dto;

import com.hanmaum.counseling.domain.post.entity.Counsel;
import com.hanmaum.counseling.domain.post.entity.Story;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class UserStoryInfoDto {
    private Long storyId;
    private String title;
    private LocalDateTime createdAt;
    private int numOfNewReply;
    private String nickname;

    @Builder
    public UserStoryInfoDto(Long storyId, String title, LocalDateTime createdAt, int numOfNewReply, String nickname) {
        this.storyId = storyId;
        this.title = title;
        this.createdAt = createdAt;
        this.numOfNewReply = numOfNewReply;
        this.nickname = nickname;
    }

    public static UserStoryInfoDto getMyStoryInfo(Story story, int numOfNewReply){
        return UserStoryInfoDto.builder()
                .storyId(story.getId())
                .title(story.getForm().getTitle())
                .createdAt(story.getCreatedAt())
                .numOfNewReply(numOfNewReply)
                .build();
    }

    public static UserStoryInfoDto getMyCounselInfo(Story story, Counsel counsel, int numOfNewReply){
        return UserStoryInfoDto.builder()
                .storyId(story.getId())
                .title(story.getForm().getTitle())
                .createdAt(story.getCreatedAt())
                .numOfNewReply(numOfNewReply)
                .nickname(counsel.getCounsellorNickname())
                .build();
    }
}
