package com.jose.pati.controller;

import com.jose.pati.model.Taller;
import com.jose.pati.service.TallerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talleres")
@RequiredArgsConstructor
@CrossOrigin
public class TallerController {
    private final TallerService tallerService;

    @GetMapping
    public List<Taller> listar() {
        return tallerService.listar();
    }

    @PostMapping
    public Taller crear(@RequestBody Taller taller) {
        return tallerService.crear(taller);
    }

    @PutMapping("/{id}")
    public Taller actualizar(@PathVariable Long id, @RequestBody Taller taller) {
        return tallerService.actualizar(id, taller);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tallerService.eliminar(id);
    }
}
