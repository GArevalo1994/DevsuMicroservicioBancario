package com.devsu.microservice.CuentaMovimiento.exception;

import com.devsu.microservice.CuentaMovimiento.entity.Cuenta;
import com.devsu.microservice.CuentaMovimiento.response.ApiResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse(false,ex.getMessage(),null));
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<ApiResponse>handleSaldo(SaldoInsuficienteException ex){
        return ResponseEntity.badRequest()
                .body(new ApiResponse(false,ex.getMessage(),null));
    }

    @ExceptionHandler(CuentaInactivaException.class)
    public ResponseEntity<ApiResponse>handleCuentaInactiva(CuentaInactivaException ex){
        return ResponseEntity.badRequest()
                .body(new ApiResponse(false,ex.getMessage(),null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse>handleGeneric(Exception ex){
        return ResponseEntity.internalServerError()
                .body(new ApiResponse(false,"Error interno:"+ex.getMessage(),null));
    }
}
