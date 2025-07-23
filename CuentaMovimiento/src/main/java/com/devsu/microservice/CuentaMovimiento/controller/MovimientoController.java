package com.devsu.microservice.CuentaMovimiento.controller;

import com.devsu.microservice.CuentaMovimiento.dto.MovimientoDTO;
import com.devsu.microservice.CuentaMovimiento.response.ApiResponse;
import com.devsu.microservice.CuentaMovimiento.service.MovimientoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService){
        this.movimientoService=movimientoService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MovimientoDTO>>registrar(@RequestBody @Valid MovimientoDTO dto){
        MovimientoDTO movimientoDTO=movimientoService.registrarMovimiento(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body((new ApiResponse<>(true,"Movimiento registrado",movimientoDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MovimientoDTO>>obtener(@PathVariable Long id){
        MovimientoDTO movimientoDTO = movimientoService.obtenerMovimientoPorId(id);
        return ResponseEntity.ok(new ApiResponse<>(true,"Movimiento encontrado",movimientoDTO));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MovimientoDTO>> actualizar(@PathVariable Long id, @RequestBody @Valid MovimientoDTO dto) {
        dto.setId(id);
        MovimientoDTO actualizado = movimientoService.actualizarMovimiento(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Movimiento actualizado", actualizado));
    }
}
