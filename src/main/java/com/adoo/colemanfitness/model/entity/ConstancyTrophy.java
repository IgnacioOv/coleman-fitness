package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("constancy")
public class ConstancyTrophy extends Trophy {
    public Boolean verifyTrophy(Athlete athlete) {

        long countAssistedExercises = athlete.getObjectives().stream()
                .map(Objective::getRoutine)
                .filter(routine -> routine != null)
                .flatMap(routine -> routine.getTrainingList().stream())
                .flatMap(training -> training.getExcerciseList().stream())
                .filter(TrainingExcercise::getAssisted)
                .count();


        return countAssistedExercises >= 12;
    }
}
