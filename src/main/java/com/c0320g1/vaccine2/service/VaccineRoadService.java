package com.c0320g1.vaccine2.service;

import com.c0320g1.vaccine2.model.VaccineRoad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VaccineRoadService {

    void save(VaccineRoad vaccineRoad);

    VaccineRoad findById(Long id);

    Page<VaccineRoad> getAll(Pageable pageable);

    Long createVaccineRoad (Long patientId,Long vaccineId,String startTime);
}
