package com.jose.pati.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class AsignacionTallerDTO {
    private Long id;
    private String confeccionista;
    private LocalDate fechaEstimada;
    private String taller;
    private Long idCorte;
    private String referencia;
    private Integer cantidad;
}
