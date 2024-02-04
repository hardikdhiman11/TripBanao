package com.example.TripBanao.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(value = CustomExceptionMessage.class)
    public ResponseEntity<Object> customExceptionMessage(CustomExceptionMessage e){
        return new ResponseEntity<>(e.getMessage(),
                HttpStatusCode.valueOf(400));
    }
}
