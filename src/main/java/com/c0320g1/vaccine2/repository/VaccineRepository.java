package com.c0320g1.vaccine2.repository;

import com.c0320g1.vaccine2.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine,Long> {

}
