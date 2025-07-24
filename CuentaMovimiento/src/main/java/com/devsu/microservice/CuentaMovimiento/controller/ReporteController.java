package com.devsu.microservice.CuentaMovimiento.controller;

import com.devsu.microservice.CuentaMovimiento.dto.ReporteDTO;
import com.devsu.microservice.CuentaMovimiento.response.ApiResponse;
import com.devsu.microservice.CuentaMovimiento.service.ReporteService;
import feign.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {
    private final ReporteService service;

    public ReporteController(ReporteService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<ReporteDTO> obtenerReporte(
         @RequestParam Long clienteId,
         @RequestParam String fechaInicio,
         @RequestParam String fechaFin){

        LocalDate inicio = LocalDate.parse(fechaInicio);
        LocalDate fin = LocalDate.parse(fechaFin);
        ReporteDTO reporte=service.generarReporte(
                clienteId,
                inicio.atStartOfDay(),
                fin.atTime(LocalTime.MAX)
        );
        return ResponseEntity.ok(reporte);
    }
}
