package com.hanmaum.counseling.domain.ban.dto;

import com.hanmaum.counseling.domain.account.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BanReportDetailDto {
    private Long id;
    private UserInfo reporter;
    private UserInfo reportedUser;
    private Long counselId;
    private String banReason;
    private LocalDateTime reportedAt;

    @Builder
    public BanReportDetailDto(Long id, UserInfo reporter, UserInfo reportedUser, Long counselId, String banReason, LocalDateTime reportedAt) {
        this.id = id;
        this.reporter = reporter;
        this.reportedUser = reportedUser;
        this.counselId = counselId;
        this.banReason = banReason;
        this.reportedAt = reportedAt;
    }

    @Getter
    public static class UserInfo{
        private Long userId;
        private String email;

        public UserInfo(){}
        public UserInfo(User user) {
            this.userId = user.getId();
            this.email = user.getEmail();
        }
    }
}
