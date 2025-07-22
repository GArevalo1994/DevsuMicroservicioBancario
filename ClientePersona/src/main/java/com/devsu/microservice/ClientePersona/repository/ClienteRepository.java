package com.devsu.microservice.ClientePersona.repository;

import com.devsu.microservice.ClientePersona.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
