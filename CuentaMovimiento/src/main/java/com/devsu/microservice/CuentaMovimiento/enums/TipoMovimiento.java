package com.devsu.microservice.CuentaMovimiento.enums;

public enum TipoMovimiento {
    DEPOSITO("Deposito"),
    RETIRO("Retiro");

    public final String value;

    TipoMovimiento(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
