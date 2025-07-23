package com.devsu.microservice.CuentaMovimiento.service.impl;

import com.devsu.microservice.CuentaMovimiento.dto.MovimientoDTO;
import com.devsu.microservice.CuentaMovimiento.entity.Cuenta;
import com.devsu.microservice.CuentaMovimiento.entity.Movimiento;
import com.devsu.microservice.CuentaMovimiento.enums.TipoMovimiento;
import com.devsu.microservice.CuentaMovimiento.exception.CuentaInactivaException;
import com.devsu.microservice.CuentaMovimiento.exception.ResourceNotFoundException;
import com.devsu.microservice.CuentaMovimiento.exception.SaldoInsuficienteException;
import com.devsu.microservice.CuentaMovimiento.mapper.MovimientoMapper;
import com.devsu.microservice.CuentaMovimiento.repository.CuentaRepository;
import com.devsu.microservice.CuentaMovimiento.repository.MovimientoRepository;
import com.devsu.microservice.CuentaMovimiento.service.MovimientoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final CuentaRepository cuentaRepository;

    public MovimientoServiceImpl (MovimientoRepository movimientoRepository,
                                 CuentaRepository cuentaRepository){
        this.movimientoRepository=movimientoRepository;
        this.cuentaRepository=cuentaRepository;

    }

    @Override
    public MovimientoDTO registrarMovimiento(MovimientoDTO dto) {
        Cuenta cuenta=cuentaRepository.findById(dto.getCuentaId())
                .orElseThrow(()-> new ResourceNotFoundException("Cuenta no encontrada id:"+dto.getCuentaId()));

        if(!Boolean.TRUE.equals(cuenta.getEstado())){
            throw new CuentaInactivaException("La cuenta esta incactiva");
        }

        BigDecimal nuevoSaldo=cuenta.getSaldoInicial().add(dto.getValor());
        if(nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
            throw new SaldoInsuficienteException("Saldo no disponible");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        Movimiento movimiento = MovimientoMapper.toEntity(dto,cuenta);
        movimiento.setSaldo(nuevoSaldo);
        movimientoRepository.save(movimiento);
        return MovimientoMapper.toDTO(movimiento);
    }

    @Override
    public MovimientoDTO obtenerMovimientoPorId(Long id) {
        Movimiento movimiento=movimientoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Movimiento no encontrado id:"+id));
        return MovimientoMapper.toDTO(movimiento);
    }

    @Override
    public MovimientoDTO actualizarMovimiento(MovimientoDTO dto) {
        Movimiento movimiento=movimientoRepository.findById(dto.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Movimiento no encontrado id:"+dto.getId()));

        Cuenta cuenta = cuentaRepository.findById(dto.getCuentaId())
                .orElseThrow(()-> new ResourceNotFoundException("Cuenta no encontrada id:"+dto.getCuentaId()));

        if(!Boolean.TRUE.equals(cuenta.getEstado())){
            throw new CuentaInactivaException("La cuenta esta inactiva");
        }

        BigDecimal nuevoSaldo=cuenta.getSaldoInicial().add(dto.getValor());
        if(nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
            throw new SaldoInsuficienteException("Saldo no disponible");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        movimiento.setTipoMovimiento(TipoMovimiento.valueOf(dto.getTipoMovimiento()));
        movimiento.setValor(dto.getValor());
        movimiento.setCuenta(cuenta);
        movimiento.setSaldo(nuevoSaldo);

        movimientoRepository.save(movimiento);

        return MovimientoMapper.toDTO(movimiento);
    }
}
