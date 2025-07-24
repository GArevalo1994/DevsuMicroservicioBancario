package com.devsu.microservice.ClientePersona.dto;

import java.io.Serializable;

public class ClientMessage implements Serializable {

    private Long id;
    private String nombre;

    public ClientMessage() {
    }

    public ClientMessage(Long id, String nombre) {
        this.id=id;
        this.nombre=nombre;
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
