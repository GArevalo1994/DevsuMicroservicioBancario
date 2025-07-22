package com.devsu.microservice.ClientePersona.service.Impl;

import com.devsu.microservice.ClientePersona.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    ClienteDTO crearCliente(ClienteDTO clienteDTO);
    ClienteDTO obtenerClientePorId(Long id);
    List<ClienteDTO> listarClientes();
    ClienteDTO actualizarCliente(Long id,ClienteDTO clienteDTO);
    void eliminarCliente(Long id);
}
