package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingExcercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long reps;
    private Long sets;
    private Float weight;

    @ManyToOne
    @JoinColumn(name = "excercise_id")
    private Excercise excercise;


    @ManyToOne
    @JoinColumn(name="training_id")
    private Training training;
}
