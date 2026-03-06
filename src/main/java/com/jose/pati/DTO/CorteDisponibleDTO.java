package com.jose.pati.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CorteDisponibleDTO {
    private Long id;
    private String mesa;
    private String referencia;
    private String material;
    private LocalDate fechaCorte;
    private Integer cantidadProgramada;
}
