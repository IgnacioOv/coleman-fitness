package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
    public void calculateObjectiveMeasurements(BodyMeasurement bodyMeasurement) {

    }
}
