package com.hanmaum.counseling.domain.model.user;

import com.hanmaum.counseling.error.WrongPasswordException;
import lombok.Builder;
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
    private Long id;

    @Column(unique = true)
    private String email;

    @Embedded
    private Password password;

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
    public User(Long id, String email, Password password, String nickname, int temperature, Long profileImgNumber, RoleType role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.temperature = temperature;
        this.profileImgNumber = profileImgNumber;
        this.role = role;
    }

    public void login(String password) {
        if (!this.password.match(password)) {
            throw new WrongPasswordException("비밀번호가 일치하지 않습니다.");
        }
    }

    public void updatePassword(String newPassword) {
        if (this.password.match(newPassword)) {
            throw new WrongPasswordException("이전 비밀번호와 동일한 비밀번호입니다.");
        }
        this.password.change(newPassword);
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
    public void setProfileImgNumber(Long profileImgNumber){this.profileImgNumber = profileImgNumber;}
    public void setNickname(String nickname) { this.nickname = nickname;}
    public void updateTemperature(int temperature){
        this.temperature += temperature;
    }
}
