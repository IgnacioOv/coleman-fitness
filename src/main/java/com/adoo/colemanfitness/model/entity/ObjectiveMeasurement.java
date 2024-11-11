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
public class ObjectiveMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float weight;
    private float muscleMass;
    private float bodyFat;
    @OneToOne
    @JoinColumn(name = "objective_id")
    private Objective objective;
}
