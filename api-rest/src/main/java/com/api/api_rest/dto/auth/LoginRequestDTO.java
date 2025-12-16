package com.api.api_rest.dto.auth;

public record LoginRequestDTO(
    String email,
    String password
) {

}
