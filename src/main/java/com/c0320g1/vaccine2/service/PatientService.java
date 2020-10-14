package com.c0320g1.vaccine2.service;

import com.c0320g1.vaccine2.model.Patient;


import java.util.List;

public interface PatientService {
   List<Patient> findAll();
   Patient findById(Long id);
   void save(Patient patient);
   List<Patient> findByParentIdCard(String idCard);
}
