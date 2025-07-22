package com.devsu.microservice.ClientePersona.controller;

import com.devsu.microservice.ClientePersona.dto.ClienteDTO;
import com.devsu.microservice.ClientePersona.response.ApiResponse;
import com.devsu.microservice.ClientePersona.service.Impl.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ClienteDTO>>crearCliente(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO creado=clienteService.crearCliente(clienteDTO);
        return ResponseEntity.ok(new ApiResponse<>(true,"Cliente creado",creado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteDTO>>obtenerCliente(@PathVariable Long id){
        ClienteDTO cliente=clienteService.obtenerClientePorId(id);
        return ResponseEntity.ok(new ApiResponse<>(true,"Cliente encontrado",cliente));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ClienteDTO>>>listarCliente(){
        List<ClienteDTO>clientes=clienteService.listarClientes();
        return ResponseEntity.ok(new ApiResponse<>(true,"Lista de clientes",clientes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteDTO>>actualizarCliente(@PathVariable Long id,@RequestBody ClienteDTO clienteDTO){
        ClienteDTO cliente=clienteService.actualizarCliente(id,clienteDTO);
        return ResponseEntity.ok(new ApiResponse<>(true,"Cliente actualizado",cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteDTO>>eliminarCliente(@PathVariable Long id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.ok(new ApiResponse<>(true,"Cliente eliminado",null));
    }
}
