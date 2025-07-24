package com.devsu.microservice.CuentaMovimiento.exception;

public class ReporteNotFoundException extends RuntimeException{

    public ReporteNotFoundException(String message){
        super(message);
    }
}
