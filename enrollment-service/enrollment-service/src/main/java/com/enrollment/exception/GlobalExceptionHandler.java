package com.enrollment.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EnrollmentNotFound.class)
    public ResponseEntity<String> EnrollmentNotFound(EnrollmentNotFound enrollmentNotFound) {
        return new ResponseEntity<>(enrollmentNotFound.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<String> globalExceptionHandler(Exception e) {
        return new ResponseEntity<>("Not found" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
