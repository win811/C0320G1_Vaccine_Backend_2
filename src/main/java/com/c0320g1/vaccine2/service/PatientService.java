package com.c0320g1.vaccine2.service;

import com.c0320g1.vaccine2.dto.PatientListDTO;
import com.c0320g1.vaccine2.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;


import java.util.List;

public interface PatientService {
   List<Patient> findAll();
   Patient findById(Long id);
   void save(Patient patient);
   List<Patient> findByParentIdCard(String idCard);

   //Thành Long
   Page<PatientListDTO> findPatientByCriteria(Specification<Patient> spec, int page);

   //Thành Long
   Specification<Patient> getFilter(String fullName, String parentName, String parentIdCard);

   //Thành Long
   Page<PatientListDTO> findAllPatient(int page);
}
