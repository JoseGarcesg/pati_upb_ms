package com.jose.pati.repository;

import com.jose.pati.model.Corte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorteRepository   extends JpaRepository<Corte, Long> {
}
