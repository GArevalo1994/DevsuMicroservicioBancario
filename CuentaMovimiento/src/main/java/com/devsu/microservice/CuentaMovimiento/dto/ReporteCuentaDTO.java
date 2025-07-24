package com.devsu.microservice.CuentaMovimiento.dto;

import java.math.BigDecimal;
import java.util.List;

public class ReporteCuentaDTO {

    private String numeroCuentas;
    private String tipo;
    private BigDecimal saldoInicial;
    private Boolean estado;
    private BigDecimal saldoDisponible;
    private List<ReporteMovimientoDTO> movimientos;

    public String getNumeroCuentas() {
        return numeroCuentas;
    }

    public void setNumeroCuentas(String numeroCuentas) {
        this.numeroCuentas = numeroCuentas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public List<ReporteMovimientoDTO> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<ReporteMovimientoDTO> movimientos) {
        this.movimientos = movimientos;
    }
}
