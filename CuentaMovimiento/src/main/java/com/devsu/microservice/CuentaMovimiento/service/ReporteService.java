package com.devsu.microservice.CuentaMovimiento.service;

import com.devsu.microservice.CuentaMovimiento.dto.ReporteDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ReporteService {

    ReporteDTO generarReporte(Long clienteId, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
