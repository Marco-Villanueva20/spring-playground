package com.api.api_rest.mapper;

import org.springframework.stereotype.Service;

import com.api.api_rest.dto.persona.PersonaResponseDTO;
import com.api.api_rest.model.Person;

@Service
public class PersonaMapper {
    public PersonaResponseDTO toPersonaResponseDTO(Person persona){
        return new PersonaResponseDTO(
            persona.getId(),
            persona.getFirstname(),
            persona.getLastname(),
            persona.getEmail()
        );
    }
}
