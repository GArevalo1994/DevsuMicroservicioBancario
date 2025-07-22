package com.devsu.microservice.ClientePersona.service;

import com.devsu.microservice.ClientePersona.mapper.ClienteMapper;
import com.devsu.microservice.ClientePersona.dto.ClienteDTO;
import com.devsu.microservice.ClientePersona.entity.Cliente;
import com.devsu.microservice.ClientePersona.entity.Persona;
import com.devsu.microservice.ClientePersona.exception.ResourceNotFoundException;
import com.devsu.microservice.ClientePersona.repository.ClienteRepository;
import com.devsu.microservice.ClientePersona.repository.PersonaRepository;
import com.devsu.microservice.ClientePersona.service.Impl.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;
    private final PersonaRepository personaRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository,PersonaRepository personaRepository){
        this.clienteRepository=clienteRepository;
        this.personaRepository=personaRepository;
    }

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        Persona persona=personaRepository.findById(clienteDTO.getPersonaId())
                .orElseThrow(()-> new ResourceNotFoundException("Persona no encontrada con id:"+clienteDTO.getPersonaId()));
        Cliente cliente= ClienteMapper.toEntity(clienteDTO,persona);
        cliente=clienteRepository.save(cliente);
        return ClienteMapper.toDTO(cliente);
    }

    @Override
    public ClienteDTO obtenerClientePorId(Long id) {
        Cliente cliente=clienteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cliente no encontrado con id:"+id));
        return ClienteMapper.toDTO(cliente);
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll()
                .stream().map(ClienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO) {

        Cliente cliente=clienteRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Cliente no encontrado con id:"+id));

        Persona persona=personaRepository.findById(clienteDTO.getPersonaId())
                .orElseThrow(()-> new ResourceNotFoundException("Persona no encontrada con id:"+clienteDTO.getPersonaId()));

        cliente.setNombre(clienteDTO.getNombre());
        cliente.setPersona(persona);

        cliente=clienteRepository.save(cliente);
        return ClienteMapper.toDTO(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Cliente no encontrado con el id:"+id));
        clienteRepository.delete(cliente);
    }
}
