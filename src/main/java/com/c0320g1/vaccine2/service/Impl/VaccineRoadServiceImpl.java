package com.c0320g1.vaccine2.service.Impl;

import com.c0320g1.vaccine2.model.Patient;
import com.c0320g1.vaccine2.model.Vaccine;
import com.c0320g1.vaccine2.model.VaccineRoad;
import com.c0320g1.vaccine2.model.VaccineRoadDetails;
import com.c0320g1.vaccine2.repository.VaccineRoadDetailsRepository;
import com.c0320g1.vaccine2.repository.VaccineRoadRepository;
import com.c0320g1.vaccine2.service.PatientService;
import com.c0320g1.vaccine2.service.VaccineRoadService;
import com.c0320g1.vaccine2.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VaccineRoadServiceImpl implements VaccineRoadService {
    @Autowired
    VaccineRoadRepository vaccineRoadRepository;

    @Autowired
    VaccineRoadDetailsRepository vaccineRoadDetailsRepository;

    @Autowired
    VaccineService vaccineService;

    @Autowired
    PatientService patientService;

    @Override
    public Boolean createVaccineRoad(Long patientId, Long vaccineId, String startTime) {


        Patient patient = this.patientService.findById(patientId);
        Vaccine vaccine = this.vaccineService.findById(vaccineId);
        if (patient == null || vaccine == null) {
            return Boolean.FALSE;
        }
        VaccineRoad vaccineRoad = new VaccineRoad();
        vaccineRoad.setPatient(patient);
        vaccineRoad.setVaccine(vaccine);
        VaccineRoad VaccineRoad = this.vaccineRoadRepository.save(vaccineRoad);

        LocalDate currentTime = LocalDate.parse(startTime);
        VaccineRoadDetails vaccineRoadDetails = new VaccineRoadDetails(VaccineRoad, currentTime,
                1,Boolean.FALSE);
        vaccineRoadDetailsRepository.save(vaccineRoadDetails);

        Integer rangeTime = vaccine.getRangeTime();

        for (int i = 2 ; i <= vaccine.getInjectionTimes() ; i++) {
            LocalDate tempTime;
            int currentDay = currentTime.getDayOfMonth();
            int currentMonth = currentTime.getMonthValue();
            int currentYear = currentTime.getYear();
            int nextMonth = currentMonth + rangeTime;
            if ( nextMonth > 12 ) {
                currentYear += 1;
                nextMonth = nextMonth - 12;
            }
            tempTime = LocalDate.of(currentYear, nextMonth, currentDay);
            VaccineRoadDetails tempRoadDetails = new VaccineRoadDetails(VaccineRoad,tempTime,i,Boolean.FALSE);
            vaccineRoadDetailsRepository.save(tempRoadDetails);
            currentTime = tempTime;
        }
        return Boolean.TRUE;
    }

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
