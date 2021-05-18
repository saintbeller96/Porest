package exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BannedUserException extends RuntimeException{
    public BannedUserException(String message) {
        super(message);
    }
}
