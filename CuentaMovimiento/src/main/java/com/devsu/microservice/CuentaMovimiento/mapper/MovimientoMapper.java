package com.devsu.microservice.CuentaMovimiento.mapper;

import com.devsu.microservice.CuentaMovimiento.dto.MovimientoDTO;
import com.devsu.microservice.CuentaMovimiento.entity.Cuenta;
import com.devsu.microservice.CuentaMovimiento.entity.Movimiento;
import com.devsu.microservice.CuentaMovimiento.enums.TipoMovimiento;

public class MovimientoMapper {

    public static MovimientoDTO toDTO(Movimiento movimiento){
        MovimientoDTO dto=new MovimientoDTO();
        dto.setId(movimiento.getId());
        dto.setCuentaId(movimiento.getCuenta().getId());
        dto.setFecha(movimiento.getFecha().toString());
        dto.setTipoMovimiento(movimiento.getTipoMovimiento().name());
        dto.setSaldo(movimiento.getSaldo());
        dto.setValor(movimiento.getValor());
        return dto;
    }

    public static Movimiento toEntity(MovimientoDTO movimientoDTO, Cuenta cuenta){
        Movimiento movimiento=new Movimiento();
        movimiento.setId(movimientoDTO.getId());
        movimiento.setTipoMovimiento(TipoMovimiento.valueOf(movimientoDTO.getTipoMovimiento()));
        movimiento.setCuenta(cuenta);
        movimiento.setSaldo(movimientoDTO.getValor());
        movimiento.setValor(movimientoDTO.getValor());
        return movimiento;
    }
}
