package com.c0320g1.vaccine2.controller;

import com.c0320g1.vaccine2.dto.PatientListDTO;
import com.c0320g1.vaccine2.model.Account;
import com.c0320g1.vaccine2.model.Patient;
import com.c0320g1.vaccine2.service.AccountService;
import com.c0320g1.vaccine2.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @GetMapping("/patientByAccount/{id}")
    public ResponseEntity<List<Patient>> findPatientByAccount (@PathVariable Long id) {
         Account account = this.accountService.findById(id);
        List<Patient> patientList;
         if (account == null) {
             return ResponseEntity.notFound().build();
         } else {
             patientList = this.patientService.findByParentIdCard(account.getIdCard());
         }
         return ResponseEntity.ok(patientList);
    }

    // Thành Long
    @GetMapping("/admin/patient-list")
    public ResponseEntity<Page<PatientListDTO>> getAllPatient(@RequestParam(name = "fullName", defaultValue = "") String fullName,
                                                              @RequestParam(name = "parentName", defaultValue = "") String parentName,
                                                              @RequestParam(name = "parentIdCard", defaultValue = "") String parentIdCard,
                                                              @RequestParam(name = "page", defaultValue = "1") int page) {
        Specification<Patient> specs = patientService.getFilter(fullName, parentName, parentIdCard);
        Page<PatientListDTO> patients;
        if (specs != null) {
            patients = patientService.findPatientByCriteria(specs, page);
        } else {
            patients = patientService.findAllPatient(page);
        }
        if (patients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(patients);
    }

    // Thành Long
    @PostMapping("/admin/patient-list/create")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        patientService.save(patient);
        return ResponseEntity.ok(patient);
    }






}
