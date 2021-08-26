package com.hanmaum.counseling.error;

public class BanReportNotFoundException extends RuntimeException {
    private static final String DEFAULT = "찾는 신고 요청이 없습니다.";

    public BanReportNotFoundException() {
        super(DEFAULT);
    }
    public BanReportNotFoundException(String msg) {
        super(msg);
    }
}
