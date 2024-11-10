package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class BodyMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float weight;
    private float muscleMass;
    private float bodyFat;
    private Long height;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;
}
