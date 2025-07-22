package com.devsu.microservice.ClientePersona.mapper;

import com.devsu.microservice.ClientePersona.dto.ClienteDTO;
import com.devsu.microservice.ClientePersona.entity.Cliente;
import com.devsu.microservice.ClientePersona.entity.Persona;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setClienteId(cliente.getClienteId());
        dto.setContrasena(cliente.getContrasena());
        dto.setEstado(cliente.getEstado());
        dto.setNombre(cliente.getNombre());
        dto.setPersonaId(cliente.getPersona() != null ? cliente.getPersona().getId() : null);
        return dto;
    }

    public static Cliente toEntity(ClienteDTO dto, Persona persona) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setClienteId(dto.getClienteId());
        cliente.setContrasena(dto.getContrasena());
        cliente.setEstado(dto.getEstado());
        cliente.setNombre(dto.getNombre());
        cliente.setPersona(persona);
        return cliente;
    }
}
