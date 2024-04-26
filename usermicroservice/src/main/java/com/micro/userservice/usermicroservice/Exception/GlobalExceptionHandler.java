package com.micro.userservice.usermicroservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.micro.userservice.usermicroservice.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerNotFoundException(ResourceNotFoundException exception) {
        String msg = exception.getMessage();
        ApiResponse build = ApiResponse.builder().msg(msg).status(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity<ApiResponse>(build, HttpStatus.NOT_FOUND);
    }

}
