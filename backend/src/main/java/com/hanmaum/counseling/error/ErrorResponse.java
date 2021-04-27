package com.hanmaum.counseling.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private String message;
    private String code;

    @Builder
    public ErrorResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
