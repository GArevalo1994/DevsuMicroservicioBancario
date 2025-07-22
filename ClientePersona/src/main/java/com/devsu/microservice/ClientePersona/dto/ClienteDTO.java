package com.devsu.microservice.ClientePersona.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteDTO {
    private Long id;

    @NotBlank(message = "El clienteId es obligatorio")
    private String clienteId;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;

    private Integer estado = 1;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El id de la persona es obligatorio")
    private Long personaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }
}
