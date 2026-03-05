package com.jose.pati.controller;

import com.jose.pati.enums.Color;
import com.jose.pati.enums.Material;
import com.jose.pati.enums.Referencia;
import com.jose.pati.enums.Talla;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/catalogos")
@CrossOrigin
public class CatalogoController {
    @GetMapping("/{tipo}")
    public ResponseEntity<List<String>> obtenerCatalogo(@PathVariable String tipo){
        switch (tipo.toLowerCase()) {

            case "talla":
                return ResponseEntity.ok(Arrays.stream(Talla.values())
                        .map(Enum::name)
                        .collect(Collectors.toList()));

            case "color":
                return ResponseEntity.ok(Arrays.stream(Color.values())
                        .map(Enum::name)
                        .collect(Collectors.toList()));

            case "material":
                return ResponseEntity.ok(Arrays.stream(Material.values())
                        .map(Enum::name)
                        .collect(Collectors.toList()));

            case "referencia":
                return ResponseEntity.ok(Arrays.stream(Referencia.values())
                        .map(Enum::name)
                        .collect(Collectors.toList()));

            default:
                throw new RuntimeException("Catálogo no encontrado");
        }
    }
}
