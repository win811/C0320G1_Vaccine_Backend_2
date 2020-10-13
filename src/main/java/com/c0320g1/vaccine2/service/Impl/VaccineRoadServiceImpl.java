package com.c0320g1.vaccine2.service.Impl;

import com.c0320g1.vaccine2.model.VaccineRoad;
import com.c0320g1.vaccine2.repository.VaccineRoadRepository;
import com.c0320g1.vaccine2.service.VaccineRoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VaccineRoadServiceImpl implements VaccineRoadService {
    @Autowired
    VaccineRoadRepository vaccineRoadRepository;

    @Override
    public void save(VaccineRoad vaccineRoad) {
        vaccineRoadRepository.save(vaccineRoad);
    }

    @Override
    public VaccineRoad findById(Long id) {
        return vaccineRoadRepository.findById(id).orElse(null);
    }

    @Override
    public Page<VaccineRoad> getAll(Pageable pageable) {
        return vaccineRoadRepository.findAll(pageable);
    }
}
