package com.c0320g1.vaccine2.service.Impl;

import com.c0320g1.vaccine2.dto.PatientListDTO;
import com.c0320g1.vaccine2.model.Patient;
import com.c0320g1.vaccine2.repository.PatientRepository;
import com.c0320g1.vaccine2.service.PatientService;
import com.c0320g1.vaccine2.service.search.PatientSpecification;
import com.c0320g1.vaccine2.service.search.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> findByParentIdCard(String idCard) {
        return this.patientRepository.findByParentIdCard(idCard);
    }

    @Override
    public Page<PatientListDTO> findPatientByCriteria(Specification<Patient> spec, int page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Patient> patients = patientRepository.findAll(spec, pageable);
        return transferToNewPage(patients);
    }

    @Override
    public Specification<Patient> getFilter(String fullName, String parentName, String parentIdCard) {
        List<PatientSpecification> specs = new ArrayList<>();
        Specification<Patient> spec;
        // search theo fullName
        if(!"".equals(fullName) && !"undefined".equals(fullName)) {
            specs.add(new PatientSpecification(new SearchCriteria("fullName", "like", fullName)));
        }
        // search theo parentName
        if(!"".equals(parentName) && !"undefined".equals(parentName) ) {
            specs.add(new PatientSpecification(new SearchCriteria("parentName", "like", parentName)));
        }
        // search theo parentIdCard
        if(!"".equals(parentIdCard) && !"undefined".equals(parentIdCard) ) {
            specs.add(new PatientSpecification(new SearchCriteria("parentIdCard", "like", parentIdCard)));
        }
        if (specs.size() != 0) {
            spec = Specification.where(specs.get(0));
            for (int i = 1; i < specs.size(); i++) {
                assert spec != null;
                spec = spec.and(specs.get(i));
            }
            return spec;
        }
        return null;
    }

    @Override
    public Page<PatientListDTO> findAllPatient(int page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Patient> patients = patientRepository.findAll(pageable);
        return transferToNewPage(patients);
    }

    // Thành Long
    private PatientListDTO transferToDTO(Patient temp) {
        PatientListDTO patient = new PatientListDTO();
        patient.setId(temp.getId());
        patient.setFullName(temp.getFullName());
        patient.setBirthDay(temp.getBirthDay());
        patient.setParentName(temp.getParentName());
        patient.setParentIdCard(temp.getParentIdCard());
        patient.setVaccineRoadList(temp.getVaccineRoadList());
        return patient;
    }

    // Thành Long
    private Page<PatientListDTO> transferToNewPage(Page<Patient> patients) {
        Patient temp;
        List<PatientListDTO> patientListDTOS = new ArrayList<>();
        Iterator iterator = patients.iterator();
        while (iterator.hasNext()) {
            temp = (Patient) iterator.next();
            patientListDTOS.add(transferToDTO(temp));
        }
        Page<PatientListDTO> _patient = new PageImpl<>(patientListDTOS, patients.getPageable(), patients.getTotalElements());
        return _patient;
    }

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
