package com.devsu.microservice.ClientePersona.exception;

public class ConflictException extends RuntimeException{

    public ConflictException(String message){
        super(message);
    }
}
