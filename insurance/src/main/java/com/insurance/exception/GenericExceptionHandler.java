package com.insurance.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Gokul-Namit on 13-04-2018.
 */

@ControllerAdvice
@RestController
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException (Exception ex, WebRequest request) {

        ExceptionResponseDetails exceptionResponseDetails = new ExceptionResponseDetails(ex.getMessage());
        return new ResponseEntity (exceptionResponseDetails, HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException (ResourceNotFoundException ex, WebRequest request) {
        ExceptionResponseDetails exceptionResponseDetails = new ExceptionResponseDetails(ex.getMessage());
        return new ResponseEntity (exceptionResponseDetails, HttpStatus.NOT_FOUND );
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResponseDetails exceptionResponseDetails = new ExceptionResponseDetails(ex.getBindingResult().toString());
        return new ResponseEntity (exceptionResponseDetails, HttpStatus.BAD_REQUEST );
    }
}
