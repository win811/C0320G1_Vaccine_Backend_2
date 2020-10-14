package com.c0320g1.vaccine2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class VaccineRoadDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vaccine_road_id")
    private VaccineRoad vaccineRoad;

    private LocalDate injectionDate;

    private Integer injectionTimes;

    private Boolean isInjected;

    public VaccineRoadDetails(VaccineRoad vaccineRoad,LocalDate injectionDate,
                              Integer injectionTimes,Boolean isInjected) {
        this.vaccineRoad = vaccineRoad;
        this.injectionDate = injectionDate;
        this.injectionTimes = injectionTimes;
        this.isInjected = isInjected;
    }
}
