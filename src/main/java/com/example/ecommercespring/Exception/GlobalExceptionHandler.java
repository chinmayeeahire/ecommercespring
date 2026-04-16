package com.example.ecommercespring.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
 
@ExceptionHandler(ProductNotFoundException.class)
public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException e){
   ErrorResponse err=new ErrorResponse(
    HttpStatus.NOT_FOUND.value(), 
    e.getMessage(),
    LocalDateTime.now());
    return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
}

@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorResponse> handleGenericException(Exception e){
    ErrorResponse err=new ErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
    "An unexpected error occurred, working on it", LocalDateTime.now());
    return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
}

//category exceptions are still handled using exception handling to have both approach code


}
