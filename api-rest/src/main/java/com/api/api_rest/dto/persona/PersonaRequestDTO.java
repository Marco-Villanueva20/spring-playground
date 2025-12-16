package com.api.api_rest.dto.persona;

public record PersonaRequestDTO(
    Integer id,
    String firstname,
    String lastname,
    String email,
    String password
) {}

