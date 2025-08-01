package com.devsu.microservice.CuentaMovimiento.dto;

import java.io.Serializable;

public class ClienteMessage implements Serializable {
    private Long id;
    private String nombre;

    public ClienteMessage(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ClienteMessage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
