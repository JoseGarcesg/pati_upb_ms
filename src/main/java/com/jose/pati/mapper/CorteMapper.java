package com.jose.pati.mapper;

import com.jose.pati.DTO.CorteDisponibleDTO;
import com.jose.pati.model.Corte;

public class CorteMapper {
    public static CorteDisponibleDTO toDisponibleDTO(Corte corte){

        CorteDisponibleDTO dto = new CorteDisponibleDTO();

        dto.setId(corte.getId());
        dto.setMesa(corte.getMesa().toString());
        dto.setReferencia(corte.getReferencia().toString());
        dto.setMaterial(corte.getMaterial().toString());
        dto.setFechaCorte(corte.getFechaCorte());
        dto.setCantidadProgramada(corte.getCantidadProgramada());

        return dto;
    }
}
