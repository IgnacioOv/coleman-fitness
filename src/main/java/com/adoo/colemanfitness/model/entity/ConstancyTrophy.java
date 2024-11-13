package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("constancy")
public class ConstancyTrophy extends Trophy {
    public Boolean verifyTrophy(Athlete athlete) {
        // Recorre cada objetivo del atleta, luego cada rutina y entrenamiento para contar los ejercicios asistidos
        long countAssistedExercises = athlete.getObjectives().stream()
                .map(Objective::getRoutine)
                .filter(routine -> routine != null) // Filtra los objetivos que tienen rutina asignada
                .flatMap(routine -> routine.getTrainingList().stream())
                .flatMap(training -> training.getExcerciseList().stream())
                .filter(TrainingExcercise::getAssisted) // Solo cuenta ejercicios asistidos
                .count();

        // Reemplaza 10 con el número de ejercicios asistidos requeridos para obtener el trofeo
        return countAssistedExercises >= 10;
    }
}
