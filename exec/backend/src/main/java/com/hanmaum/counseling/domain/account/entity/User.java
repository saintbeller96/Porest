package com.hanmaum.counseling.domain.account.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    //TODO : 닉네임 삭제 예정
    @Column
    private String nickname;

    @Column(name = "temperature", columnDefinition = "integer default 36")
    private int temperature;

    @Column
    private String profileImg;

    @Column
    @ColumnDefault("1")
    private Long profileImgNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @ColumnDefault("'ROLE_USER'")
    private RoleType role;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Builder
    public User(String email, String password, String nickname, int temperature,  Long profileImgNumber, RoleType role) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.temperature = temperature;
        this.profileImgNumber = profileImgNumber;
        this.role = role;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
    public void setProfileImgNumber(Long profileImgNumber){this.profileImgNumber = profileImgNumber;}
    public void setPassword(String password){ this.password = password; }
    public void setNickname(String nickname) { this.nickname = nickname;}
    public void setTemperature(int temperature){this.temperature = temperature;}
}
