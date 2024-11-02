package com.adoo.colemanfitness.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Excercise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String muscleGroup;
    private Float aerobicLevel;
    private String video;

    @OneToMany(mappedBy = "excercise", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TrainingExcercise> trainingExcercises;


}
