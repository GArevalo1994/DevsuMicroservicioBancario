package com.devsu.microservice.ClientePersona.messaging.publisher;

import com.devsu.microservice.ClientePersona.dto.ClientMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ClientePublisher {
    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    public ClientePublisher(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    public void publicarCliente(ClientMessage message){
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }
}
