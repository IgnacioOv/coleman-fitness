package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Tone")
public class ToneObjective extends Objective {

    public ToneObjective(){
        setMinAerobicLevel(1F);
        setMaxAerobicLevel(4F);
        setMinTrainTime(120L);
        setMaxTrainTime(150L);
    }

    @Override
    public ObjectiveMeasurement calculateObjectiveMeasurements(BodyMeasurement bodyMeasurement) {
        ObjectiveMeasurement objectiveMeasurement = new ObjectiveMeasurement();
        objectiveMeasurement.setBodyFat(bodyMeasurement.getWeight() * 0.15F);
        objectiveMeasurement.setMuscleMass(bodyMeasurement.getWeight() * 0.4F);
        objectiveMeasurement.setWeight(bodyMeasurement.getWeight());
        this.setObjectiveMeasurement(objectiveMeasurement);
        return objectiveMeasurement;
    }

    @Override
    public Boolean verifyObjectiveState(BodyMeasurement bodyMeasurement) {
        ObjectiveMeasurement objectiveMeasurement = this.getObjectiveMeasurement();
        if(bodyMeasurement.getBodyFat() <= objectiveMeasurement.getBodyFat() && bodyMeasurement.getMuscleMass() >= objectiveMeasurement.getMuscleMass()){
            this.setState("Completed");
            System.out.println("Objective completed");
            return true;
        }
        return false;
    }


}
