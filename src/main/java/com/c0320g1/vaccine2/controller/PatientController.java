package com.c0320g1.vaccine2.controller;

import com.c0320g1.vaccine2.model.Account;
import com.c0320g1.vaccine2.model.Patient;
import com.c0320g1.vaccine2.repository.PatientRepository;
import com.c0320g1.vaccine2.service.AccountService;
import com.c0320g1.vaccine2.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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






}
