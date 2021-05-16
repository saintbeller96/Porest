package com.hanmaum.counseling.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserCounselStateDto {
    private Long counselId;
    private String writerNickname;
    private String title;
    private int numOfReplies;
    private LocalDateTime updatedAt;

    @Builder
    public UserCounselStateDto(Long counselId, String nickname, String title, int numOfReplies, LocalDateTime updatedAt) {
        this.counselId = counselId;
        this.writerNickname = nickname;
        this.title = title;
        this.numOfReplies = numOfReplies;
        this.updatedAt = updatedAt;
    }
}
