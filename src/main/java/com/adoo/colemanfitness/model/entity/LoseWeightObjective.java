package com.adoo.colemanfitness.model.entity;


import com.adoo.colemanfitness.model.dto.ObjectiveMeasurementDto;
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
    public void calculateObjectiveMeasurements(BodyMeasurement bodyMeasurement) {
        Long idealWeight = bodyMeasurement.getHeight() - 100;
        ObjectiveMeasurementDto objectiveMeasurementDto = new ObjectiveMeasurementDto();
        objectiveMeasurementDto.setWeight(idealWeight);
        objectiveMeasurementDto.setBodyFat(null);
        objectiveMeasurementDto.setMuscleMass(null);
    }
}
