package com.example.ob_springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringdatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObSpringdatajpaApplication.class, args);

		CocheRepository repository = context.getBean(CocheRepository.class);
		System.out.println("El numero de coches en base de datos es: " + repository.count());
		Coche toyota = new Coche(null, "Toyota", "Prius",2019);
		repository.save(toyota);
		System.out.println("El numero de coches en base de datos es: " + repository.count());
	}

}
