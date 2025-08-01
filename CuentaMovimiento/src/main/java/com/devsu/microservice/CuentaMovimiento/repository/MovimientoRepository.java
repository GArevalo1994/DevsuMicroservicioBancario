package com.devsu.microservice.CuentaMovimiento.repository;

import com.devsu.microservice.CuentaMovimiento.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {
    List<Movimiento> findByCuentaIdAndFechaBetween(Long cuentaId, LocalDateTime inicio, LocalDateTime fin);
}
