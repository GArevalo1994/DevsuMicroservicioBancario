package com.devsu.microservice.ClientePersona.service.integration;

import com.devsu.microservice.ClientePersona.dto.ClienteDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.util.Assert;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class ClienteRabbitIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testClienteCreacion_EmiteMensajeRabbitMQ()throws Exception{
        String url="http://localhost:" + port + "/api/clientes";

        ClienteDTO clienteDTO=new ClienteDTO();
        clienteDTO.setNombre("Integration test");
        clienteDTO.setClienteId("CL0183");
        clienteDTO.setContrasena("12345");
        clienteDTO.setEstado(true);
        clienteDTO.setPersonaId(6L);

        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ClienteDTO>request=new HttpEntity<>(clienteDTO,headers);

        ResponseEntity<String> response= restTemplate.postForEntity(url,request,String.class);
        System.out.println("body:"+response.getBody());
        System.out.println("code:"+response.getStatusCode());
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Object message=rabbitTemplate.receiveAndConvert("clientes.created.queue");
        Assertions.assertThat(message).isNotNull();

    }
}
