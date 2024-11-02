package com.adoo.colemanfitness.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "excercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainingExcercise> trainingExcercises = new ArrayList<>();

    // Método para agregar un TrainingExcercise a la lista
    public void addTrainingExcercise(TrainingExcercise trainingExcercise) {
        trainingExcercises.add(trainingExcercise);
        trainingExcercise.setExcercise(this);
    }

    // Método para eliminar un TrainingExcercise de la lista
    public void removeTrainingExcercise(TrainingExcercise trainingExcercise) {
        trainingExcercises.remove(trainingExcercise);
        trainingExcercise.setExcercise(null);
    }
}
