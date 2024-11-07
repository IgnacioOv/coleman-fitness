package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Tone")
public class ToneObjective extends Objective {

    public void ToneObjective(){
        setMinAerobicLevel(1L);
        setMaxAerobicLevel(4L);
        setMinTrainTime(120L);
        setMaxTrainTime(150L);
    }
}
