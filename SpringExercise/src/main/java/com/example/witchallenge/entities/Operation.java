package com.example.witchallenge.entities;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Operation {
    //ATTRS
    private String type;
    private BigDecimal a;
    private BigDecimal b;

    //CONSTRUCTOR
    public Operation(@JsonProperty("type") String type,
                     @JsonProperty("a") BigDecimal a, @JsonProperty("b") BigDecimal b) {
        this.type = type;
        this.a = a;
        this.b = b;
    }

    // GETTERS
    public String getType() { return type; }
    public BigDecimal getA() { return a; }
    public BigDecimal getB() { return b; }
}
