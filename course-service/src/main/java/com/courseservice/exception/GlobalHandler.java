package com.courseservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {


    @ExceptionHandler(CourseNotFound.class)
    public ResponseEntity<String> handleException(CourseNotFound courseNotFound){
        return  new ResponseEntity<>(courseNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<String> apiException(Exception e){
        return  new ResponseEntity<>("Not found"+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
