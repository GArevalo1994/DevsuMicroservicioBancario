package com.devsu.microservice.CuentaMovimiento.service.impl;

import com.devsu.microservice.CuentaMovimiento.dto.ReporteCuentaDTO;
import com.devsu.microservice.CuentaMovimiento.dto.ReporteDTO;
import com.devsu.microservice.CuentaMovimiento.dto.ReporteMovimientoDTO;
import com.devsu.microservice.CuentaMovimiento.entity.ClienteCache;
import com.devsu.microservice.CuentaMovimiento.entity.Cuenta;
import com.devsu.microservice.CuentaMovimiento.entity.Movimiento;
import com.devsu.microservice.CuentaMovimiento.exception.ReporteNotFoundException;
import com.devsu.microservice.CuentaMovimiento.exception.ResourceNotFoundException;
import com.devsu.microservice.CuentaMovimiento.repository.ClienteCacheRepository;
import com.devsu.microservice.CuentaMovimiento.repository.CuentaRepository;
import com.devsu.microservice.CuentaMovimiento.repository.MovimientoRepository;
import com.devsu.microservice.CuentaMovimiento.service.ReporteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final CuentaRepository cuentaRepository;
    private final MovimientoRepository movimientoRepository;

    private final ClienteCacheRepository cacheRepository;

    public ReporteServiceImpl(CuentaRepository cuentaRepository,
                              MovimientoRepository movimientoRepository,
                              ClienteCacheRepository cacheRepository){
        this.cuentaRepository=cuentaRepository;
        this.movimientoRepository=movimientoRepository;
        this.cacheRepository=cacheRepository;
    }


    @Override
    public ReporteDTO generarReporte(Long clienteId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<Cuenta> cuentas=cuentaRepository.findByClienteId(clienteId);
        if(cuentas.isEmpty()){
            throw new ReporteNotFoundException("No se encontraron cuentas para el cliente:"+clienteId);
        }

        ClienteCache clienteCache=cacheRepository.findById(clienteId)
                .orElseThrow(()->new ResourceNotFoundException("Cliente no encontrado"));

        ReporteDTO reporte=new ReporteDTO();
        reporte.setClienteId(clienteId.toString());
        reporte.setNombre(clienteCache.getNombre());

        reporte.setCuentas(
                cuentas.stream().map(cuenta -> {
                     ReporteCuentaDTO cuentaDTO=new ReporteCuentaDTO();
                     cuentaDTO.setNumeroCuentas(cuenta.getNumeroCuenta());
                     cuentaDTO.setTipo(cuenta.getTipo().getValue());
                     cuentaDTO.setSaldoInicial(cuenta.getSaldoInicial());
                     cuentaDTO.setEstado(cuenta.getEstado());
                     cuentaDTO.setSaldoDisponible(cuenta.getSaldoInicial());

                    List<Movimiento> movimientos = movimientoRepository
                            .findByCuentaIdAndFechaBetween(cuenta.getId(), fechaInicio, fechaFin);

                    cuentaDTO.setMovimientos(
                            movimientos.stream().map(mov -> {
                                ReporteMovimientoDTO movDTO = new ReporteMovimientoDTO();
                                movDTO.setFecha(mov.getFecha().toString());
                                movDTO.setTipoMovimiento(mov.getTipoMovimiento().getValue());
                                movDTO.setValor(mov.getValor());
                                movDTO.setSaldo(mov.getSaldo());
                                return movDTO;
                            }).collect(Collectors.toList())
                    );

                    return cuentaDTO;
                }).collect(Collectors.toList())
        );
        return reporte;
    }
}
