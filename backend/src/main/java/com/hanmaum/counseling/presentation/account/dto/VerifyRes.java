package com.hanmaum.counseling.presentation.account.dto;

import lombok.Data;

@Data
public class VerifyRes {
    private String message;
    private boolean verify;

    public VerifyRes() {}

    public VerifyRes(String message, boolean verify) {
        this.message = message;
        this.verify = verify;
    }
}
