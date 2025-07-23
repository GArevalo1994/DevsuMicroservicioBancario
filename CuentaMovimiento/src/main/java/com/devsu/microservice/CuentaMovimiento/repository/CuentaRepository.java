package com.devsu.microservice.CuentaMovimiento.repository;

import com.devsu.microservice.CuentaMovimiento.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Long> {
}
