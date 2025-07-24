package com.devsu.microservice.CuentaMovimiento.messaging.listener;

import com.devsu.microservice.CuentaMovimiento.dto.ClienteMessage;
import com.devsu.microservice.CuentaMovimiento.entity.ClienteCache;
import com.devsu.microservice.CuentaMovimiento.repository.ClienteCacheRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ClienteListener {
    private final ClienteCacheRepository clienteCacheRepository;

    public ClienteListener(ClienteCacheRepository clienteCacheRepository){
        this.clienteCacheRepository=clienteCacheRepository;
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void recibirCliente(ClienteMessage message){
        System.out.println("Recibido cliente desde cola:"+message.getId());
        ClienteCache cliente=new ClienteCache();
        cliente.setId(message.getId());
        cliente.setNombre(message.getNombre());
        clienteCacheRepository.save(cliente);
    }
}
