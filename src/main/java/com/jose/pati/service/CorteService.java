package com.jose.pati.service;

import com.jose.pati.enums.EstadoCorte;
import com.jose.pati.model.Corte;
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
}
