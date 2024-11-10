package com.adoo.colemanfitness.model.entity;


import com.adoo.colemanfitness.model.dto.ObjectiveMeasurementDto;
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
    public void calculateObjectiveMeasurements(BodyMeasurement bodyMeasurement) {
        ObjectiveMeasurementDto objectiveMeasurementDto = new ObjectiveMeasurementDto();
        objectiveMeasurementDto.setBodyFat(bodyMeasurement.getWeight() * 0.15F);
        objectiveMeasurementDto.setMuscleMass(bodyMeasurement.getWeight() * 0.4F);

    }
}
