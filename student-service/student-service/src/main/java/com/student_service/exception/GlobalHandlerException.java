package com.student_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> GlobalException(Exception exception) {
        return new ResponseEntity<>("Not found"+exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<String> handleException(StudentNotFound studentNotFound) {
        return new ResponseEntity<>("Not found"+studentNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }
}
