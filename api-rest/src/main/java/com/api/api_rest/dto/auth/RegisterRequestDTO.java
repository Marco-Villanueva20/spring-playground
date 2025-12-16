package com.api.api_rest.dto.auth;

import com.api.api_rest.user.Role;

public record RegisterRequestDTO(
    String username,
    String password,
    String firstname,
    String lastname,
    String country,
    Role role
) {

} 
