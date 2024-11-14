package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@DiscriminatorValue("constancy")
public class ConstancyTrophy extends Trophy {
    public Boolean verifyTrophy(Athlete athlete) {

        List<Objective> objectiveList = athlete.getObjectives();
        Objective currentObjective = objectiveList.get(objectiveList.size()-1);
        List<Routine> routines = currentObjective.getRoutines();
        Routine currentRoutine = routines.get(routines.size()-1);
        List<Training> trainingList = currentRoutine.getTrainingList();

        for (Training training : trainingList){
            if(!training.getAssisted()){
                return false;
            }else{
                List<TrainingExcercise> trainingExcercises = training.getExcerciseList();
                for(TrainingExcercise trainingExcercise : trainingExcercises){
                    if(!trainingExcercise.getAssisted()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
