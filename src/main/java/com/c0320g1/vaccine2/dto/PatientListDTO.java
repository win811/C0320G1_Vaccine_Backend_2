package com.c0320g1.vaccine2.dto;

import java.time.LocalDate;
import java.util.List;

public class PatientListDTO {
    private String fullName;

    private LocalDate birthDay;

    private String parentName;

    private String parentIdCard;

    private List<String> vaccineRoadList;

    public PatientListDTO() {
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

    public List<String> getVaccineRoadList() {
        return vaccineRoadList;
    }

    public void setVaccineRoadList(List<String> vaccineRoadList) {
        this.vaccineRoadList = vaccineRoadList;
    }
}
