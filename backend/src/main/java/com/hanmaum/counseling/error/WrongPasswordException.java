package com.hanmaum.counseling.error;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String message) {
        super(message);
    }
}
