package com.example.restcrudapi.errorHandlers;

import com.example.restcrudapi.exceptions.EmployeeNotFoundException;
import com.example.restcrudapi.responses.ErrorResponse;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        var error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException ex) {
        var status = HttpStatus.NOT_FOUND.value();
        var errorMessage = ex.getMessage();
        var timeStamp = System.currentTimeMillis();

        var error = new ErrorResponse(status, errorMessage, timeStamp);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler({EmployeeNotFoundException.class, StudentNotFoundException.class})
//    public ResponseEntity<ErrorResponse> handleException(RuntimeException ex) {
//        var error = new ErrorResponse(
//                HttpStatus.NOT_FOUND.value(),
//                ex.getMessage(),
//                System.currentTimeMillis()
//        );
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
// can be used instead several Exception handlers
}
