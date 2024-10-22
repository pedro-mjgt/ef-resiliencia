package com.example.ef_resiliencia.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class CitaService {

    @CircuitBreaker(name = "myService")
    public String registrarCita(String pago) {
        if (procesarPago(pago)) {
            return "Cita pagada exitosamente";
        }
        else {
            throw new RuntimeException("Error con el pago");
        }
    }
    
    private boolean procesarPago(String pago) {
        return pago.equals("valido");
    }

}
