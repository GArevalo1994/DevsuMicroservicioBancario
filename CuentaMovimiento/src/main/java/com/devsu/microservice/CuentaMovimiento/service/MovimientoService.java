package com.devsu.microservice.CuentaMovimiento.service;

import com.devsu.microservice.CuentaMovimiento.dto.MovimientoDTO;
import org.springframework.stereotype.Service;

@Service
public interface MovimientoService {

    MovimientoDTO registrarMovimiento(MovimientoDTO dto);
    MovimientoDTO obtenerMovimientoPorId(Long id);
    MovimientoDTO actualizarMovimiento(MovimientoDTO dto);
}
