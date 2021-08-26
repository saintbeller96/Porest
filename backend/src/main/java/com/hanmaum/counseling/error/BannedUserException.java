package com.hanmaum.counseling.error;

public class BannedUserException extends RuntimeException{
    private static final String DEFAULT = "해당 계정은 신고로 인해 정지되었습니다.";

    public BannedUserException() {
        super(DEFAULT);
    }
    public BannedUserException(String msg) {
        super(msg);
    }
}
