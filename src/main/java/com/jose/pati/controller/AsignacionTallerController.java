package com.jose.pati.controller;

import com.jose.pati.DTO.AsignacionTallerDTO;
import com.jose.pati.DTO.AsignacionTallerRequest;
import com.jose.pati.model.AsignacionTaller;
import com.jose.pati.service.AsignacionTallerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
@RequiredArgsConstructor
@CrossOrigin
public class AsignacionTallerController {
    private final AsignacionTallerService asignacionTallerService;
    @PostMapping
    public ResponseEntity<AsignacionTaller> asignarTaller(@RequestBody AsignacionTallerRequest asignacionTallerRequest){
        return ResponseEntity.ok(asignacionTallerService.asignarTaller(asignacionTallerRequest));
    }

    @GetMapping("/taller/{tallerId}")
    public ResponseEntity<List<AsignacionTaller>> listarPorTaller(@PathVariable Long tallerId) {
        return ResponseEntity.ok(asignacionTallerService.listarPorTaller(tallerId));
    }

    @GetMapping
    public ResponseEntity<List<AsignacionTallerDTO>> listar() {
        return ResponseEntity.ok(asignacionTallerService.listar());
    }

    @DeleteMapping("/{asignacionId}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long asignacionId){
        asignacionTallerService.eliminar(asignacionId);
        return ResponseEntity.noContent().build();
    }
}
