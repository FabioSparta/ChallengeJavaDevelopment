package com.example.witchallenge.controllers;

import com.example.witchallenge.services.client.Client;
import com.example.witchallenge.services.server.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CalculatorRestController {

    @Autowired
    private Client client;

    HashMap<String,BigDecimal> answer = new HashMap<>();

    @GetMapping("/sum")
    public ResponseEntity<Object> getSum(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        BigDecimal resultVal= client.sendAndWaitAnswer("+",a,b);
        answer.put("result", resultVal);
        return new ResponseEntity<>(answer,HttpStatus.OK);
    }

    @GetMapping("/sub")
    public ResponseEntity<Object> getSubtraction(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        BigDecimal resultVal= client.sendAndWaitAnswer("-",a,b);
        answer.put("result", resultVal);
        return new ResponseEntity<>(answer,HttpStatus.OK);
    }

    @GetMapping("/mul")
    public ResponseEntity<Object> getMultiplication(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        BigDecimal resultVal= client.sendAndWaitAnswer("*",a,b);
        answer.put("result", resultVal);
        return new ResponseEntity<>(answer,HttpStatus.OK);
    }

    @GetMapping("/div")
    public ResponseEntity<Object> getDivision(@RequestParam BigDecimal a, @RequestParam BigDecimal b){
        BigDecimal resultVal= client.sendAndWaitAnswer("/",a,b);
        answer.put("result", resultVal);
        return new ResponseEntity<>(answer,HttpStatus.OK);
    }
}
