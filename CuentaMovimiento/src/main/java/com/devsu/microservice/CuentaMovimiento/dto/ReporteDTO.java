package com.devsu.microservice.CuentaMovimiento.dto;

import java.util.List;

public class ReporteDTO {

    private String nombre;
    private String clienteId;
    private List<ReporteCuentaDTO> cuentas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public List<ReporteCuentaDTO> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<ReporteCuentaDTO> cuentas) {
        this.cuentas = cuentas;
    }
}
