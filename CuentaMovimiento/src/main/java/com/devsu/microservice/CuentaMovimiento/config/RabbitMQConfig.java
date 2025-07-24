package com.devsu.microservice.CuentaMovimiento.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.routingKey}")
    private String routingKey;
    @Value("${rabbitmq.queue}")
    private String queue;

    @Bean
    public Queue queue(){
        return new Queue(queue,true);
    }

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding binding(Queue queue,DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
