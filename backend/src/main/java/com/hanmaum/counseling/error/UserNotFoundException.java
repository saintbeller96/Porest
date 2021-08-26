package com.hanmaum.counseling.error;

public class UserNotFoundException extends RuntimeException {
    private static final String DEFAULT = "찾는 사용자가 없습니다.";

    public UserNotFoundException() {
        super(DEFAULT);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
