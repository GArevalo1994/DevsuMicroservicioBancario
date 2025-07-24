package com.devsu.microservice.CuentaMovimiento.enums;

public enum TipoCuenta {

    AHORRO("Ahorro"),
    CORRIENTE("Corriente");

    private final String value;

     TipoCuenta(String value){
        this.value=value;
    }

    public String getValue(){
         return value;
    }
}
