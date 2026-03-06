package com.jose.pati.service;

import com.jose.pati.model.Taller;
import com.jose.pati.repository.TallerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TallerService {
    private final TallerRepository tallerRepository;

    public List<Taller> listar() {
        return tallerRepository.findAll();
    }

    public Taller crear(Taller taller) {
        return tallerRepository.save(taller);
    }

    public Taller actualizar(Long id, Taller taller) {

        Taller tallerExistente = tallerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Taller no encontrado"));

        tallerExistente.setNombre(taller.getNombre());

        return tallerRepository.save(tallerExistente);
    }

    public void eliminar(Long id) {
        tallerRepository.deleteById(id);
    }
}
