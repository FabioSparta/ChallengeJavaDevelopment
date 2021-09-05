package com.example.witchallenge.services.server;
import com.example.witchallenge.entities.Operation;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


@Service
public class Calculator {

    public static final int PRECISION = 10;

    @RabbitListener(queues = "challenge.rpc.requests")
    public BigDecimal result(Operation operation){
        switch(operation.getType()) {
            case "+":
                return getSum(operation.getA(),operation.getB());
            case "-":
                return getSubtraction(operation.getA(),operation.getB());
            case "*":
                return getMultiplication(operation.getA(),operation.getB());
            case "/":
                return getDivision(operation.getA(),operation.getB());
            default:
                return new BigDecimal(0);
        }
    }

    public BigDecimal getSum(BigDecimal a, BigDecimal b) { return a.add(b) ; }

    public BigDecimal getSubtraction( BigDecimal a,  BigDecimal b) { return a.subtract(b); }

    public BigDecimal getMultiplication( BigDecimal a,  BigDecimal b) {
        return a.multiply(b, new MathContext(PRECISION, RoundingMode.DOWN));
    }

    public BigDecimal getDivision( BigDecimal a,  BigDecimal b) {
        return a.divide(b, new MathContext(PRECISION, RoundingMode.DOWN)) ;
    }
}
