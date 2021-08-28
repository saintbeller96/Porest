package com.hanmaum.counseling.error;

public class CounselAccessDeniedException extends RuntimeException{
    private static final String DEFAULT = "현재 유저는 이 상담 내역에 접근할 수 없습니다";

    public CounselAccessDeniedException() {
        super(DEFAULT);
    }
    public CounselAccessDeniedException(String msg) {
        super(msg);
    }
}
