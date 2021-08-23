package com.hanmaum.counseling.error;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }
}
