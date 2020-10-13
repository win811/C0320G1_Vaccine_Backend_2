package com.c0320g1.vaccine2.service;

import com.c0320g1.vaccine2.model.VaccineRoadDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VaccineRoadDetailsService {

    void save(VaccineRoadDetails vaccineRoadDetails);

    VaccineRoadDetails findById(Long id);

    Page<VaccineRoadDetails> getAll(Pageable pageable);
}
