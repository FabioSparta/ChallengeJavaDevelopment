package com.example.witchallenge.services.client;

import com.example.witchallenge.entities.Operation;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class Client {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange exchange;


    public BigDecimal sendAndWaitAnswer(String type, BigDecimal a, BigDecimal b ) {
        Operation op = new Operation(type,a,b);

        // this sends the operation to be solved to the server side and returns the answer when it comes
        return (BigDecimal) template.convertSendAndReceive
                (exchange.getName(), "rpc",op);
    }
}
