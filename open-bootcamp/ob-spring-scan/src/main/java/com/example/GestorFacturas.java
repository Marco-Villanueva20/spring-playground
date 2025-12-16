package com.example;

import org.springframework.stereotype.Component;

@Component()
public class GestorFacturas {

    //1 atributo
    Calculadora calculadora;

    
    //2 Constructor
    public GestorFacturas(Calculadora calculadora) {
        System.out.println("Ejecutando constructor GestorFactura");
        this.calculadora = calculadora;

    }

    //3 métodos




}
