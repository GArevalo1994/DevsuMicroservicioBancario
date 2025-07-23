package com.devsu.microservice.CuentaMovimiento.controller;

import com.devsu.microservice.CuentaMovimiento.dto.CuentaDTO;
import com.devsu.microservice.CuentaMovimiento.response.ApiResponse;
import com.devsu.microservice.CuentaMovimiento.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {
    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService){
        this.cuentaService=cuentaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CuentaDTO>>obtenerCuente(@PathVariable Long id){
        CuentaDTO cuenta=cuentaService.obtenerCuentaPorId(id);
        return ResponseEntity.ok().body(new ApiResponse<>(true,"Cuenta encontrada",cuenta));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<CuentaDTO>>crearCuenta(@RequestBody @Valid CuentaDTO dto){
        CuentaDTO cuenta=cuentaService.crearCuenta(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true,"Cuenta creada",cuenta));
    }
    @PutMapping
    public ResponseEntity<ApiResponse<CuentaDTO>>updateCuenta(@PathVariable Long id,@RequestBody @Valid CuentaDTO dto){
        CuentaDTO cuenta=cuentaService.actualizarCuenta(dto);
         return ResponseEntity.ok(new ApiResponse<>(true,"Cuenta actualizada",cuenta));
    }
}
