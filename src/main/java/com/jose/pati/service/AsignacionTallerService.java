package com.jose.pati.service;

import com.jose.pati.DTO.AsignacionTallerDTO;
import com.jose.pati.DTO.AsignacionTallerRequest;
import com.jose.pati.enums.EstadoCorte;
import com.jose.pati.enums.Mesa;
import com.jose.pati.mapper.AsignacionTallerMapper;
import com.jose.pati.model.AsignacionTaller;
import com.jose.pati.model.Corte;
import com.jose.pati.model.Taller;
import com.jose.pati.repository.AsignacionTallerRepository;
import com.jose.pati.repository.CorteRepository;
import com.jose.pati.repository.TallerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignacionTallerService {
    private final AsignacionTallerRepository asignacionTallerRepository;
    private final CorteRepository  corteRepository;
    private final TallerRepository  tallerRepository;


    @Transactional
    public AsignacionTaller asignarTaller(AsignacionTallerRequest asignacionTallerRequest){
        if(asignacionTallerRepository.existsByCorteId(asignacionTallerRequest.getCorteId())){
            throw  new RuntimeException("Ya existe una taller con el mismo corte asignado");
        }

        Corte corte = corteRepository.findById(asignacionTallerRequest.getCorteId())
                .orElseThrow(()-> new RuntimeException("Corte no encontrado"));
        Taller taller = tallerRepository.findById(asignacionTallerRequest.getTallerId())
                .orElseThrow(() -> new RuntimeException("Taller no encontrado"));

        AsignacionTaller asignacionTaller = new AsignacionTaller();
        asignacionTaller.setCorte(corte);
        asignacionTaller.setTaller(taller);
        asignacionTaller.setConfeccionista(asignacionTallerRequest.getConfeccionista());
        asignacionTaller.setFechaEstimada(asignacionTallerRequest.getFechaEstimada());

        //cambiar estado del corte a asignado
        corte.setEstado(EstadoCorte.ASIGNADO);
        //si se le asigna a un taller la mesa es externa
        corte.setMesa(Mesa.EXTERNA);
        corteRepository.save(corte);

        return asignacionTallerRepository.save(asignacionTaller);
    }

    public List<AsignacionTaller> listarPorTaller(Long tallerId) {
        if (!tallerRepository.existsById(tallerId)) {
            throw new RuntimeException("Taller no encontrado");
        }

        return asignacionTallerRepository.findByTallerId(tallerId);
    }

    public List<AsignacionTallerDTO> listar() {
        return asignacionTallerRepository.findAll()
                .stream()
                .map(AsignacionTallerMapper::toDTO)
                .toList();
    }
}
