package com.devsu.microservice.CuentaMovimiento.exception;

public class CuentaInactivaException extends RuntimeException{

    public CuentaInactivaException(String message){
        super(message);
    }
}
