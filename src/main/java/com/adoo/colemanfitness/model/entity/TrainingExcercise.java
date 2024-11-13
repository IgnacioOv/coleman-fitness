package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class TrainingExcercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long reps;
    private Long sets;
    private Float weight;
    private Boolean assisted; // Indica si el ejercicio asignado fue asistido

    @ManyToOne
    @JoinColumn(name = "excercise_id")
    private Excercise excercise;


    @ManyToOne
    @JoinColumn(name="training_id")
    private Training training;
}
