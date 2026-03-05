package com.jose.pati.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jose.pati.enums.EstadoCorte;
import com.jose.pati.enums.Material;
import com.jose.pati.enums.Referencia;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Corte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mesa;
    private LocalDate fechaCorte;

    @Enumerated(EnumType.STRING)
    private Referencia referencia;

    @Enumerated(EnumType.STRING)
    private Material material;

    private Integer cantidadProgramada;

    @Enumerated(EnumType.STRING)
    private EstadoCorte estado;

    @OneToMany(mappedBy = "corte", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleCorte> detalles;
}
