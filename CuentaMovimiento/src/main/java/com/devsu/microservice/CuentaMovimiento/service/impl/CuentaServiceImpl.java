package com.devsu.microservice.CuentaMovimiento.service.impl;

import com.devsu.microservice.CuentaMovimiento.dto.CuentaDTO;
import com.devsu.microservice.CuentaMovimiento.entity.Cuenta;
import com.devsu.microservice.CuentaMovimiento.enums.TipoCuenta;
import com.devsu.microservice.CuentaMovimiento.exception.ResourceNotFoundException;
import com.devsu.microservice.CuentaMovimiento.mapper.CuentaMapper;
import com.devsu.microservice.CuentaMovimiento.repository.CuentaRepository;
import com.devsu.microservice.CuentaMovimiento.service.CuentaService;
import org.springframework.stereotype.Service;

@Service

public class CuentaServiceImpl implements CuentaService {

    public final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository){
        this.cuentaRepository=cuentaRepository;
    }

    @Override
    public CuentaDTO crearCuenta(CuentaDTO dto) {
        Cuenta cuenta = CuentaMapper.toEntity(dto);
        cuentaRepository.save(cuenta);
        return CuentaMapper.toDTO(cuenta);
    }

    @Override
    public CuentaDTO obtenerCuentaPorId(Long id) {
        Cuenta cuenta=cuentaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Cuenta no encontrada id:"+id));
        return CuentaMapper.toDTO(cuenta);
    }

    @Override
    public CuentaDTO actualizarCuenta(CuentaDTO dto) {
        Cuenta cuenta=cuentaRepository.findById(dto.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Cuenta no encontrada id:"+dto.getId()));
        cuenta.setNumeroCuenta(dto.getNumeroCuenta());
        cuenta.setTipo(TipoCuenta.valueOf(dto.getTipo()));
        cuenta.setSaldoInicial(dto.getSaldoInicial());
        cuenta.setEstado(dto.getEstado());
        cuenta.setClienteId(dto.getClienteId());

        cuentaRepository.save(cuenta);
        return CuentaMapper.toDTO(cuenta);
    }
}
