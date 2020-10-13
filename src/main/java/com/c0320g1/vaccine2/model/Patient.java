package com.c0320g1.vaccine2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String fullName;
    private String gender;
    private LocalDate birthDay;
    private String parentName;
    private String parentIdCard;
    private String address;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "patient")
    @JsonIgnoreProperties(value = {"patient"})
    private List<VaccineRoad> vaccineRoadList;
}
