package com.c0320g1.vaccine2.service.Impl;

import com.c0320g1.vaccine2.model.VaccineRoadDetails;
import com.c0320g1.vaccine2.repository.VaccineRoadDetailsRepository;
import com.c0320g1.vaccine2.service.VaccineRoadDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineRoadDetailsServiceImpl implements VaccineRoadDetailsService {
    @Autowired
    VaccineRoadDetailsRepository vaccineRoadDetailsRepository;

    @Override
    public List<VaccineRoadDetails> findAll() {
        return vaccineRoadDetailsRepository.findAll();
    }

    @Override
    public VaccineRoadDetails save(VaccineRoadDetails vaccineRoadDetails) {
      return vaccineRoadDetailsRepository.save(vaccineRoadDetails);
    }

    @Override
    public VaccineRoadDetails findById(Long id) {
        return vaccineRoadDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public Page<VaccineRoadDetails> getAll(Pageable pageable) {
        return vaccineRoadDetailsRepository.findAll(pageable);
    }
}
