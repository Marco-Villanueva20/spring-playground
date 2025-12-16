package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        //Crear el Application Context que será el contenedor de spring
        //Hacer referencia al archivo xml que contiene los beans
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //Concepto 1: Como obtener un bean del contenedor de spring
        //Opción 1: Crear el objeto de forma normal:
        //Calculadora calculadora = new Calculadora();

        //Opción 2: Recibir el objeto de spring
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");
        String texto = calculadora.greating();
        System.out.println(texto);

        //Se puede volver a obtener
        // OJO es el mismo objeto de la opción 1
        Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");
        texto = calculadora2.greating();
        System.out.println(texto);

        // Concepto 2: cargar un bean dentro de otro bean
        GestorFacturas gestorFacturas = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestorFacturas.calculadora.greating());

        //Concepto 3
        // los beans por defecto son singleton, se crea el objeto y se reutiliza para toda la aplicación
        // podemos cambiarlo a scope="prototype" si queremos qie se cree un nuevo objeto cada vez



    }
}
