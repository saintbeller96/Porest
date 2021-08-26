package com.hanmaum.counseling.error;

public class CounselNotFoundException extends RuntimeException{
    private static final String DEFAULT = "찾는 상담이 없습니다.";

    public CounselNotFoundException() {
        super(DEFAULT);
    }
    public CounselNotFoundException(String msg) {
        super(msg);
    }
}
