package com.adoo.colemanfitness.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Excercise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String muscleGroup;
    private Float aerobicLevel;
    private Long sets;
    private Long reps;
    private Float weight;
    private String video;

    @OneToMany(mappedBy = "excercise", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<TrainingExcercise> trainingExcercises = new ArrayList<>();

}
