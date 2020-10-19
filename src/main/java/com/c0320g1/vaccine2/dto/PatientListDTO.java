package com.c0320g1.vaccine2.dto;

import com.c0320g1.vaccine2.model.VaccineRoad;

import java.time.LocalDate;
import java.util.List;

public class PatientListDTO {

    private Long id;

    private String fullName;

    private LocalDate birthDay;

    private String parentName;

    private String parentIdCard;

    private List<VaccineRoad> vaccineRoadList;

    public PatientListDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentIdCard() {
        return parentIdCard;
    }

    public void setParentIdCard(String parentIdCard) {
        this.parentIdCard = parentIdCard;
    }

    public List<VaccineRoad> getVaccineRoadList() {
        return vaccineRoadList;
    }

    public void setVaccineRoadList(List<VaccineRoad> vaccineRoadList) {
        this.vaccineRoadList = vaccineRoadList;
    }
}
