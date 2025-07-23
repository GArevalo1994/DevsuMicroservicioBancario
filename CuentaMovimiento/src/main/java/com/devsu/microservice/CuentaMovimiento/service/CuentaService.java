package com.devsu.microservice.CuentaMovimiento.service;

import com.devsu.microservice.CuentaMovimiento.dto.CuentaDTO;
import org.springframework.stereotype.Service;

@Service
public interface CuentaService {
    CuentaDTO crearCuenta(CuentaDTO cuenta);
    CuentaDTO obtenerCuentaPorId(Long id);
    CuentaDTO actualizarCuenta(CuentaDTO cuenta);
}
