package com.jose.pati.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jose.pati.enums.Color;
import com.jose.pati.enums.Talla;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DetalleCorte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Talla talla;

    @Enumerated(EnumType.STRING)
    private Color color;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "corte_id")
    @JsonBackReference
    private Corte corte;
}
