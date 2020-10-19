package com.c0320g1.vaccine2.service.Impl;

import com.c0320g1.vaccine2.model.Vaccine;
import com.c0320g1.vaccine2.repository.VaccineRepository;
import com.c0320g1.vaccine2.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {
    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    public List<Vaccine> findAll() {
        return this.vaccineRepository.findAll();
    }

    @Override
    public void save(Vaccine vaccine) {
        vaccineRepository.save(vaccine);
    }

    @Override
    public Vaccine findById(Long id) {
        return vaccineRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Vaccine> findAll(Pageable pageable) {
        return vaccineRepository.findAll(pageable);
    }
}
