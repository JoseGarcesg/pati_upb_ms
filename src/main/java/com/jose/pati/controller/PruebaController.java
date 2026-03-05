package com.jose.pati.controller;

import com.jose.pati.model.Prueba;
import com.jose.pati.service.PruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pruebas")
@RequiredArgsConstructor
@CrossOrigin
public class PruebaController {
    private final PruebaService service;

    @PostMapping
    public ResponseEntity<Prueba>  crearPrueba(@RequestBody Prueba prueba) {
        return ResponseEntity.ok(service.crear(prueba));
    }

    @GetMapping
    public List<Prueba> listarPrueba() {
        return service.listar();
    }
}
