package com.jose.pati.repository;

import com.jose.pati.model.Taller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TallerRepository extends JpaRepository<Taller,Long> {
}
