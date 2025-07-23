package com.devsu.microservice.CuentaMovimiento.mapper;

import com.devsu.microservice.CuentaMovimiento.dto.CuentaDTO;
import com.devsu.microservice.CuentaMovimiento.entity.Cuenta;
import com.devsu.microservice.CuentaMovimiento.enums.TipoCuenta;

public class CuentaMapper {

    public static CuentaDTO toDTO(Cuenta cuenta){
        CuentaDTO dto= new CuentaDTO();
        dto.setClienteId(cuenta.getClienteId());
        dto.setEstado(cuenta.getEstado());
        dto.setNumeroCuenta(cuenta.getNumeroCuenta());
        dto.setId(cuenta.getId());
        dto.setSaldoInicial(cuenta.getSaldoInicial());
        dto.setTipo(cuenta.getTipo().name());
        return dto;
    }

    public static Cuenta toEntity(CuentaDTO dto){
        Cuenta cuenta=new Cuenta();
        cuenta.setNumeroCuenta(dto.getNumeroCuenta());
        cuenta.setClienteId(dto.getClienteId());
        cuenta.setEstado(dto.getEstado());
        cuenta.setId(dto.getId());
        cuenta.setTipo(TipoCuenta.valueOf(dto.getTipo()));
        cuenta.setSaldoInicial(dto.getSaldoInicial());
        return cuenta;
    }
}
