package com.c0320g1.vaccine2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    private Integer injectionTimes;

    private Boolean isInjected;
}
