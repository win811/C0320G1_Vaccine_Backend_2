package com.c0320g1.vaccine2.service;

import com.c0320g1.vaccine2.model.VaccineRoadDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VaccineRoadDetailsService {

    VaccineRoadDetails save(VaccineRoadDetails vaccineRoadDetails);

    VaccineRoadDetails findById(Long id);

    Page<VaccineRoadDetails> getAll(Pageable pageable);

    List<VaccineRoadDetails> findAll();
}
