package com.c0320g1.vaccine2.repository;

import com.c0320g1.vaccine2.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    List<Patient> findByParentIdCard(String idCard);
}
