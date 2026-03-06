package com.jose.pati.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class AsignacionTaller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String confeccionista;
    private LocalDate fechaEstimada;

    @ManyToOne
    private Taller taller;

    @OneToOne
    private Corte corte;
}
