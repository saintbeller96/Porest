package com.hanmaum.counseling.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCounselStateDto {
    private Long counselId;
    private String writerNickname;
    private String title;
    private int numOfReplies;

    @Builder
    public UserCounselStateDto(Long counselId, String nickname, String title, int numOfReplies) {
        this.counselId = counselId;
        this.writerNickname = nickname;
        this.title = title;
        this.numOfReplies = numOfReplies;
    }
}
