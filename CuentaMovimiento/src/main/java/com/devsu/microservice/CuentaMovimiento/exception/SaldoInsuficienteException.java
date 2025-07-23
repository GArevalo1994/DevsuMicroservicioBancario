package com.devsu.microservice.CuentaMovimiento.exception;

public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException(String message){
        super(message);
    }
}
