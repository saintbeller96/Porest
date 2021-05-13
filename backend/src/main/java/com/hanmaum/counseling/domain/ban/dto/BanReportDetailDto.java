package com.hanmaum.counseling.domain.ban.dto;

import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.post.dto.DetailCounselDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class BanReportDetailDto {
    private Long id;
    private UserInfo reporter;
    private UserInfo reportedUser;
    private DetailCounselDto counsel;
    private String banReason;
    private LocalDateTime reportedAt;

    @Builder
    public BanReportDetailDto(Long id, UserInfo reporter, UserInfo reportedUser, DetailCounselDto counsel, String banReason, LocalDateTime reportedAt) {
        this.id = id;
        this.reporter = reporter;
        this.reportedUser = reportedUser;
        this.counsel = counsel;
        this.banReason = banReason;
        this.reportedAt = reportedAt;
    }

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
