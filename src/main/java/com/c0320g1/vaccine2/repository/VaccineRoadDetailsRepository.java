package com.c0320g1.vaccine2.repository;

import com.c0320g1.vaccine2.model.VaccineRoadDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRoadDetailsRepository extends JpaRepository<VaccineRoadDetails,Long> {
}
