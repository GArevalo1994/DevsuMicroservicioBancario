package com.devsu.microservice.ClientePersona.exception;

import com.devsu.microservice.ClientePersona.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleNotFound(ResourceNotFoundException ex){
        ErrorResponse err= new ErrorResponse(ex.getMessage(),"Resource not found");
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse>handleBadRequest(BadRequestException ex){
        ErrorResponse err = new ErrorResponse(ex.getMessage(),"Bad request");
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse>handleConflict(ConflictException ex){
        ErrorResponse err = new ErrorResponse(ex.getMessage(), "Conflict");
        return new ResponseEntity<>(err,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>handleAll(Exception ex){
        ErrorResponse err=new ErrorResponse(ex.getMessage(),"Internal error");
        return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
