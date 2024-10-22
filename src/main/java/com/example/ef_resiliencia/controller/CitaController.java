package com.example.ef_resiliencia.controller;

import com.example.ef_resiliencia.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/citas")
public class CitaController {

    private final CitaService citaService;

    @PostMapping
    public ResponseEntity<String> registrarCita(
            @RequestBody Map<String, String> body
    ) {
        String pago = body.get("pago");

        try {
            String respuesta = citaService.registrarCita(pago);
            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
        }
        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
