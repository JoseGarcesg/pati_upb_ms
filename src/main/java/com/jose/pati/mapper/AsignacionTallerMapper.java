package com.jose.pati.mapper;

import com.jose.pati.DTO.AsignacionTallerDTO;
import com.jose.pati.model.AsignacionTaller;

public class AsignacionTallerMapper {
    public static AsignacionTallerDTO toDTO(AsignacionTaller a) {

        AsignacionTallerDTO dto = new AsignacionTallerDTO();

        dto.setId(a.getId());
        dto.setConfeccionista(a.getConfeccionista());
        dto.setFechaEstimada(a.getFechaEstimada());
        dto.setTaller(a.getTaller().getNombre());
        dto.setReferencia(a.getCorte().getReferencia().toString());
        dto.setCantidad(a.getCorte().getCantidadProgramada());
        dto.setIdCorte(a.getCorte().getId());
        return dto;
    }
}
