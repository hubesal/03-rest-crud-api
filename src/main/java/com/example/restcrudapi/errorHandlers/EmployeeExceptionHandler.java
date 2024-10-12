package com.example.restcrudapi.errorHandlers;

import com.example.restcrudapi.exceptions.EmployeeNotFoundException;
import com.example.restcrudapi.exceptions.StudentNotFoundException;
import com.example.restcrudapi.responses.ErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(1) // when several @controllerAdvice is applied, they're taken in random order. That's why it's better to set it
public class EmployeeExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException ex) {
        var status = HttpStatus.NOT_FOUND.value();
        var errorMessage = ex.getMessage();
        var timeStamp = System.currentTimeMillis();

        var error = new ErrorResponse(status, errorMessage, timeStamp);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
