package com.c0320g1.vaccine2.repository;

import com.c0320g1.vaccine2.model.VaccineRoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRoadRepository extends JpaRepository<VaccineRoad,Long> {
}
