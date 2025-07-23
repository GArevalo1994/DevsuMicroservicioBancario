package com.devsu.microservice.CuentaMovimiento.repository;

import com.devsu.microservice.CuentaMovimiento.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {
}
