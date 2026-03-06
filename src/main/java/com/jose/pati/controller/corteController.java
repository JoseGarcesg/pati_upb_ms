package com.jose.pati.controller;

import com.jose.pati.model.Corte;
import com.jose.pati.service.CorteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cortes")
@RequiredArgsConstructor
@CrossOrigin
public class corteController {

    private final CorteService corteService;
    @PostMapping
    public ResponseEntity<Corte> crearCorte(@RequestBody Corte corte) {
        return ResponseEntity.ok(corteService.crearCorte(corte));
    }

    @GetMapping
    public ResponseEntity<List<Corte>> listarCortes() {
        return ResponseEntity.ok(corteService.listarCortes());
    }

    @PatchMapping("/{id}/estado/{estado}")
    public ResponseEntity<Corte> actualizarEstado(
            @PathVariable Long id,
            @PathVariable String estado
    ) {
        return ResponseEntity.ok(corteService.actualizarEstado(id, estado));
    }
}
