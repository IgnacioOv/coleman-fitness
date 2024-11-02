package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<Trophy> trophyList;
    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<BodyMeasurement> bodyMeasurementList;
    @OneToOne(mappedBy = "athlete",cascade = CascadeType.ALL)
    private Objective objective;





}
