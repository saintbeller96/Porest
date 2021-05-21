package com.hanmaum.counseling.global;

import com.hanmaum.counseling.error.ErrorResponse;
import exception.BannedUserException;
import exception.UserNotFoundException;
import exception.WrongPasswordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.security.auth.login.LoginException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionController {

    //Request Body 유효성 검사시 발생하는 예외 핸들링
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String, String> errorResponse = new ConcurrentHashMap<>();
        e.getBindingResult().getAllErrors()
                .forEach(error->errorResponse.put(((FieldError) error).getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errorResponse);
    }

    //엔티티의 제약조건이 위배되면 발생하는 예외 핸들링
    @ExceptionHandler(value = ConstraintViolationException.class) // 유효성 검사 실패 시 발생하는 예외를 처리
    public ResponseEntity<?> handleException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        Set<String> errorResponse = constraintViolations.stream()
                .map(this::mappingErrorMessage)
                .collect(Collectors.toUnmodifiableSet());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(value = LoginException.class)
    public ResponseEntity<?> loginException(LoginException e){
        return ResponseEntity.badRequest().body(ErrorResponse.builder()
                .message(e.getMessage())
                .code(e.toString())
                .build());
    }
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<?> userNotFoundException(Exception e){
        return ResponseEntity.badRequest().body(ErrorResponse.builder()
                .message(e.getMessage())
                .code(e.toString())
                .build());
    }

    @ExceptionHandler(value = WrongPasswordException.class)
    public ResponseEntity<?> wrongPasswordException(WrongPasswordException e){
        return ResponseEntity.badRequest().body(ErrorResponse.builder()
                .message(e.getMessage())
                .code(e.toString())
                .build());
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<?> noSuchElementException(NoSuchElementException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .message(e.getMessage())
                        .code(e.toString()).
                                build());
    }

    private String mappingErrorMessage(ConstraintViolation<?> cv){
        final String path = cv.getPropertyPath().toString();
        final String property = path.substring(path.lastIndexOf('.') + 1);
        return String.format("{} is {}.{}", property, cv.getInvalidValue(), cv.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalStateException(IllegalStateException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .message(e.getMessage())
                        .code(e.toString()).
                                build());
    }

    @ExceptionHandler(BannedUserException.class)
    public ResponseEntity<ErrorResponse> handleBannedUserException(BannedUserException e){
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(ErrorResponse.builder()
                        .message(e.getMessage())
                        .code(e.toString()).build());
    }

    //나머지 예외는 서버 에러로 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception e){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder()
                        .message(e.getMessage())
                        .code(e.toString()).
                build());
    }
}
