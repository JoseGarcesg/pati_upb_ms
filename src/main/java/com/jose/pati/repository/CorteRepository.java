package com.jose.pati.repository;

import com.jose.pati.enums.EstadoCorte;
import com.jose.pati.model.Corte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorteRepository   extends JpaRepository<Corte, Long> {

    List<Corte> findByEstado(EstadoCorte estado);
}
