package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Maintain")
public class MaintainObjective extends Objective {

    public MaintainObjective(){
        setMinAerobicLevel(2F);
        setMaxAerobicLevel(4F);
        setMinTrainTime(45L);
        setMaxTrainTime(75L);
    }

    @Override
    public ObjectiveMeasurement calculateObjectiveMeasurements(BodyMeasurement bodyMeasurement) {
        ObjectiveMeasurement objectiveMeasurement = new ObjectiveMeasurement();
        objectiveMeasurement.setBodyFat(bodyMeasurement.getBodyFat());
        objectiveMeasurement.setMuscleMass(bodyMeasurement.getMuscleMass());
        objectiveMeasurement.setWeight(bodyMeasurement.getWeight());
        this.setObjectiveMeasurement(objectiveMeasurement);
        return objectiveMeasurement;
    }

    @Override
    public Boolean verifyObjectiveState(BodyMeasurement bodyMeasurement) {
        return false;
    }
}
