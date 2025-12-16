package com.api.api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.api_rest.model.Person;

@Repository
public interface PersonaRepository extends JpaRepository<Person, Long> {
    public Person findByEmailAndPassword(String email, String password);
}
