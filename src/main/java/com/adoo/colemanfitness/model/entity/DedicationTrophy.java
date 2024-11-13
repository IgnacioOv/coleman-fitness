package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@DiscriminatorValue("dedication")
public class DedicationTrophy extends Trophy {
    public Boolean verifyTrophy(Athlete athlete) {

        List<Objective> objectives = athlete.getObjectives();
        Objective objective = objectives.get(objectives.size()-1);
        List<BodyMeasurement> bodyMeasurements = athlete.getBodyMeasurementList();
        BodyMeasurement bodyMeasurement = bodyMeasurements.get(bodyMeasurements.size()-1);
        return objective.verifyObjectiveState(bodyMeasurement);
    }
}
