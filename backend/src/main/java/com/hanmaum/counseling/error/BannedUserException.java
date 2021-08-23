package com.hanmaum.counseling.error;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BannedUserException extends RuntimeException{
    public BannedUserException(String message) {
        super(message);
    }
}
