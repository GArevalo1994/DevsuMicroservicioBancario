package com.devsu.microservice.CuentaMovimiento.entity;

import com.devsu.microservice.CuentaMovimiento.enums.TipoCuenta;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "numero_cuenta",unique = true,nullable = false)
    private String numeroCuenta;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCuenta tipo;
    @Column(name = "saldo_inicial", nullable = false)
    private BigDecimal saldoInicial;
    private Boolean estado=true;
    @Column(name = "cliente_id", nullable = false)
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

    public TipoCuenta getTipo() {
        return tipo;
    }

    public void setTipo(TipoCuenta tipo) {
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
