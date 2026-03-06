package com.jose.pati.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AsignacionTallerRequest {
    private Long corteId;
    private Long tallerId;
    private String confeccionista;
    private LocalDate   fechaEstimada;
}
