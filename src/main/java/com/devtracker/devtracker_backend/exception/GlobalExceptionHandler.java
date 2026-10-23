package com.devtracker.devtracker_backend.exception;
import com.devtracker.devtracker_backend.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import  org.springframework.web.bind.MethodArgumentNotValidException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)

        public ResponseEntity<ErrorResponse>handleUserNotFound
        (MethodArgumentNotValidException exception) {

        ErrorResponse error = new ErrorResponse(404,
                "Invalid request data"
                , LocalDateTime.now());
    return ResponseEntity
            .badRequest()
            .body(error);
    }
    @ExceptionHandler(EmailAlreadyExistException.class)

    public ResponseEntity<ErrorResponse>handleEmailAlreadyExist(
            EmailAlreadyExistException exception){
        ErrorResponse error = new ErrorResponse( 409,
                exception.getMessage(),
                LocalDateTime.now());
        return ResponseEntity
                .status((HttpStatus.CONFLICT))
                .body(error);
    }
    }
