package com.devsu.microservice.ClientePersona.repository;

import com.devsu.microservice.ClientePersona.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
