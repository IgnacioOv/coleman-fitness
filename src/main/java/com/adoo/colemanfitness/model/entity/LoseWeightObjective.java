package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("Lose_weight")
public class LoseWeightObjective extends Objective {



    public LoseWeightObjective(){
        setMinAerobicLevel(3F);
        setMaxAerobicLevel(10F);
        setMinTrainTime(60L);
        setMaxTrainTime(90L);
    }

    @Override
    public ObjectiveMeasurement calculateObjectiveMeasurements(BodyMeasurement bodyMeasurement) {
        Long idealWeight = bodyMeasurement.getHeight() - 100;
        ObjectiveMeasurement objectiveMeasurement = new ObjectiveMeasurement();
        objectiveMeasurement.setWeight(idealWeight);
        objectiveMeasurement.setBodyFat(bodyMeasurement.getBodyFat());
        objectiveMeasurement.setMuscleMass(bodyMeasurement.getMuscleMass());
        return objectiveMeasurement;
    }

    @Override
    public void verifyObjectiveState(BodyMeasurement bodyMeasurement) {
        ObjectiveMeasurement objectiveMeasurement = this.getObjectiveMeasurement();
        if(bodyMeasurement.getWeight() <= objectiveMeasurement.getWeight()){
            this.setState("Completed");
            System.out.println("Objective completed");
        }
    }
}
