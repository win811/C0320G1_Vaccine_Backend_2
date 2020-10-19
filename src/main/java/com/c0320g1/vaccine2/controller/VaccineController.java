package com.c0320g1.vaccine2.controller;


import com.c0320g1.vaccine2.model.Vaccine;
import com.c0320g1.vaccine2.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VaccineController {

    @Autowired
    VaccineService vaccineService;

    @GetMapping("/all-vaccine")
    public ResponseEntity<List<Vaccine>> getAllVaccine() {
        return ResponseEntity.ok(this.vaccineService.findAll());
    }
}
