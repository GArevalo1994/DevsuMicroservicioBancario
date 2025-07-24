package com.devsu.microservice.ClientePersona.service;

import com.devsu.microservice.ClientePersona.dto.ClienteDTO;
import com.devsu.microservice.ClientePersona.entity.Cliente;
import com.devsu.microservice.ClientePersona.exception.ResourceNotFoundException;
import com.devsu.microservice.ClientePersona.mapper.ClienteMapper;
import com.devsu.microservice.ClientePersona.repository.ClienteRepository;
import com.devsu.microservice.ClientePersona.service.Impl.ClienteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    public ClienteServiceImplTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerClientePorId_existente_devuelveClienteDTO(){
        Cliente cliente=new Cliente();
        cliente.setId(1l);

        ClienteDTO clienteDTO = ClienteMapper.toDTO(cliente);

        Mockito.when(clienteRepository.findById(cliente.getId()))
                .thenReturn(Optional.of(cliente));

        ClienteDTO result=clienteService.obtenerClientePorId(cliente.getId());
        Assertions.assertNotNull(result);
        Assertions.assertEquals(clienteDTO.getClienteId(), result.getClienteId());
    }

    @Test
    public void obtenerClientePorId_noExistente_lanzaException(){
        Mockito.when(clienteRepository.findById(99L))
                .thenReturn(Optional.empty());

        ResourceNotFoundException exception=
                Assertions.assertThrows(ResourceNotFoundException.class,()->{
                    clienteService.obtenerClientePorId(99L);
                });
        Assertions.assertEquals("Cliente no encontrado con id:99",exception.getMessage());
    }
}
