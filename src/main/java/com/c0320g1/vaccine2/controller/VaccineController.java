package com.c0320g1.vaccine2.controller;


import com.c0320g1.vaccine2.model.Vaccine;
import com.c0320g1.vaccine2.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class VaccineController {

    @Autowired
    VaccineService vaccineService;

    @GetMapping("/vaccine-storage")
    public ResponseEntity<Page<Vaccine>> getPageVaccine( @PageableDefault(size = 8) Pageable pageable ) {
        return ResponseEntity.ok(this.vaccineService.findAll(pageable));
    }

    @GetMapping("/all-vaccine")
    public ResponseEntity<List<Vaccine>> getAllVaccine() {
        return ResponseEntity.ok(this.vaccineService.findAll());
    }

    @GetMapping("/vaccine/{id}")
    public ResponseEntity<Vaccine> getVaccineById(@PathVariable Long id) {
        return ResponseEntity.ok(this.vaccineService.findById(id));
    }
}
