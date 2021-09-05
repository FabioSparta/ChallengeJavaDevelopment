package com.example.witchallenge.services.server;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("server")
@Configuration
public class ServerConfiguration {

    @Bean
    public Queue queue() {
        return new Queue("challenge.rpc.requests");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("challenge.rpc");
    }

    @Bean
    public Binding binding(DirectExchange exchange,
                           Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("rpc");
    }

    @Bean
    public Calculator serverCalculator() {
        return new Calculator();
    }
}
