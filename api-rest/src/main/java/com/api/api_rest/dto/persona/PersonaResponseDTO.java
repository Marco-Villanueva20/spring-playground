package com.api.api_rest.dto.persona;

public record PersonaResponseDTO(
    Long id,
    String firstname,
    String lastname,
    String email
) {

}
