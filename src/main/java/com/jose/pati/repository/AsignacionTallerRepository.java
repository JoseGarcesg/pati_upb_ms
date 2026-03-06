package com.jose.pati.repository;

import com.jose.pati.model.AsignacionTaller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionTallerRepository extends JpaRepository<AsignacionTaller, Long> {
    boolean existsByCorteId(Long corteId);
    List<AsignacionTaller> findByTallerId(Long tallerId);
}
