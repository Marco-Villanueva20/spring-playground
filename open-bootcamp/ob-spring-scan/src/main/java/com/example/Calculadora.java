package com.example;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {
    public Calculadora(){
        System.out.println("Ejecutando el constructor de calculator service");
    }
    public String greating(){
        return "Hello world";
    }
}
