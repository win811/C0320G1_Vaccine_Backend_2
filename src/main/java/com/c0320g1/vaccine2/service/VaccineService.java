package com.c0320g1.vaccine2.service;

import com.c0320g1.vaccine2.model.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VaccineService {

    void save(Vaccine vaccine);

    Vaccine findById(Long id);

    Page<Vaccine> findAll(Pageable pageable);

    List<Vaccine> findAll();
}
