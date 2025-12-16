package com.api.api_rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api_rest.dto.persona.PersonaResponseDTO;
import com.api.api_rest.model.Person;
import com.api.api_rest.service.PersonaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("api/v1/person")
@RequiredArgsConstructor
public class PersonaController {


    private final PersonaService personaService;

    @GetMapping
    public List<Person> listarPersonas() {
        return personaService.listarPersonas();
    }

    @PostMapping
    public Person crearPersona(@RequestBody Person persona) {
        
        return personaService.crearPersona(persona);
    }
    
    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable Long id){
        personaService.borrarPersona(id);
    }

    @GetMapping("/{id}")
    public Person buscarPersonaPorId(@PathVariable Long id){
        return personaService.buscarPersonaPorId(id);
    }

    @PutMapping
    public void modificarPersona(@RequestBody Person persona) {
         personaService.modificarPersona(persona);
    }

    @PostMapping("/login")
    public PersonaResponseDTO login(@RequestBody Person persona) {
        return personaService.login(persona.getEmail(), persona.getPassword());
    }
    
    
    
}
