package com.c0320g1.vaccine2.controller;


import com.c0320g1.vaccine2.model.VaccineRoad;
import com.c0320g1.vaccine2.model.VaccineRoadDetails;
import com.c0320g1.vaccine2.service.VaccineRoadDetailsService;
import com.c0320g1.vaccine2.service.VaccineRoadService;
import com.c0320g1.vaccine2.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class VaccineRoadController {

    @Autowired
    VaccineRoadService vaccineRoadService;

    @Autowired
    VaccineRoadDetailsService vaccineRoadDetailsService;

    @PutMapping("/update-road-detail")
    public ResponseEntity<VaccineRoadDetails> updateVaccineRoadDetails(@RequestParam Long detailId,
                                                                       @RequestParam String isInjected) {
        VaccineRoadDetails detail = vaccineRoadDetailsService.findById(detailId);
        detail.setIsInjected(Boolean.parseBoolean(isInjected));
        return ResponseEntity.ok(vaccineRoadDetailsService.save(detail));
    }

    @PostMapping("/create-vaccine-road")
    public ResponseEntity<Void> createVaccineRoad (@RequestParam Long patientId,
                                                   @RequestParam Long vaccineId,
                                                   @RequestParam String startTime) {
        this.vaccineRoadService.createVaccineRoad(patientId,vaccineId,startTime);
        return ResponseEntity.ok().build();
    }
}
