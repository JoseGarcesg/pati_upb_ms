package com.jose.pati.service;

import com.jose.pati.enums.EstadoCorte;
import com.jose.pati.model.Corte;
import com.jose.pati.model.Taller;
import com.jose.pati.repository.CorteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CorteService {
    private final CorteRepository corteRepository;

    public Corte crearCorte(Corte corte) {
        corte.setEstado(EstadoCorte.SIN_ASIGNAR);
        if (corte.getDetalles() != null){
            corte.getDetalles().forEach(detalle -> detalle.setCorte(corte));
        }

        return corteRepository.save(corte);
    }

    public List<Corte> listarCortes(){
        return corteRepository.findAll();
    }


    public Corte actualizarEstado(Long id, String estado) {
        Corte corte = corteRepository.findById(id)
                .orElseThrow(() ->  new RuntimeException("Corte no encontrado"));

        EstadoCorte estadoCorte;
        try {
            estadoCorte = EstadoCorte.valueOf(estado.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Estado inválido: " + estado);
        }

        corte.setEstado(estadoCorte);
        return  corteRepository.save(corte);
    }
}
