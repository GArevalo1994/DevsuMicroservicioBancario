package com.devsu.microservice.CuentaMovimiento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CuentaDTO {
    private Long id;
    @NotBlank(message = "El número de cuenta es obligatorio")
    private String numeroCuenta;
    @NotBlank(message = "El tipo de cuenta es obligatorio")
    private String tipo;
    @NotNull(message = "El saldo inicial es obligatorio")
    private BigDecimal saldoInicial;
    @NotNull(message = "El estado es obligatorio")
    private Boolean estado;
    @NotNull(message = "El clienteId es obligatorio")
    private Long clienteId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
