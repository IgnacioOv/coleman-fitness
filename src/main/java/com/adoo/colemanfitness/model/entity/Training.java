package com.adoo.colemanfitness.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "routine_id")
    private Routine routine;

    @OneToMany(mappedBy = "training")
    @ToString.Exclude
    private List<TrainingExcercise> excerciseList;

    private Long duration;
    private String muscleGroup;
    private Boolean assisted;

    // Método para rastrear un ejercicio específico
    public void trackExercise(Long exerciseId, Long sets, Long reps, Float weight) {
        // Aquí puedes implementar la lógica para rastrear el ejercicio
        for (TrainingExcercise trainingExcercise : excerciseList) {
            if (trainingExcercise.getExcercise().getId().equals(exerciseId)) {
                // Lógica para rastrear el ejercicio
                System.out.println("Ejercicio: " + trainingExcercise.getExcercise().getName() +
                        ", Sets: " + sets + ", Reps: " + reps + ", Weight: " + weight);
                break; // Salir del bucle si se encontró el ejercicio
            }
        }
    }
}