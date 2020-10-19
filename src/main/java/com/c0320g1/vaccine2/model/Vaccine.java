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
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private LocalDate receiveDate;
    private LocalDate expiryDate;
    private String country;
    private Double content;
    private Integer amount;
    private String conditions;
    private Double limitAge;
    private String inventoryStatus;
    private Double price;
    private Integer injectionTimes;
    private Integer rangeTime;
    private String image;

    @OneToMany(mappedBy = "vaccine")
    @JsonIgnoreProperties({"vaccine","patient"})
    private List<VaccineRoad> vaccineRoadList;
}
