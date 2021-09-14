package com.hanmaum.counseling.api.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;

@Getter
@NoArgsConstructor
public class ProfileImgDto {
    private File profileImg;

    @Builder
    public ProfileImgDto(File profileImg) {
        this.profileImg = profileImg;
    }
}
