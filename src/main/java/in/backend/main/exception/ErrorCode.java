package in.backend.main.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    UNAUTHENTICATED("Unauthenticated", HttpStatus.UNAUTHORIZED),
    USER_NOT_FOUND("User Not Found", HttpStatus.NOT_FOUND),
    ;


    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
