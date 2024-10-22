package com.example.restcrudapi.errorHandlers;

import com.example.restcrudapi.exceptions.StudentNotFoundException;
import com.example.restcrudapi.responses.ErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(1)
public class StudentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(StudentNotFoundException ex) {
        var error = new ErrorResponse();

        // error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        //we can instantiate above ones in the constructor too - example below

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
