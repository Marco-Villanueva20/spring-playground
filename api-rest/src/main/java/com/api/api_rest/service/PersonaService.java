package com.api.api_rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.api_rest.dto.persona.PersonaResponseDTO;
import com.api.api_rest.mapper.PersonaMapper;
import com.api.api_rest.model.Person;
import com.api.api_rest.repository.PersonaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaService {


    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    public Person crearPersona(Person persona){
        return personaRepository.save(persona);
    }
    public void borrarPersona(Long id){
        personaRepository.deleteById(id);
    }

    public List<Person> listarPersonas(){
        return personaRepository.findAll();
    }

    public Person buscarPersonaPorId(Long id){
        return personaRepository.findById(id).orElse(null);
    }
    public void modificarPersona(Person persona) {
        personaRepository.save(persona);
    }

    public PersonaResponseDTO login(String email, String password) {
        return personaMapper.toPersonaResponseDTO(personaRepository.findByEmailAndPassword(email, password));
    }

}
