package com.c0320g1.vaccine2.service.Impl;

import com.c0320g1.vaccine2.model.Patient;
import com.c0320g1.vaccine2.repository.PatientRepository;
import com.c0320g1.vaccine2.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Patient patient) {
            patientRepository.save(patient);
    }
}
