package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Entity
@DiscriminatorValue("Tone")
public class ToneObjective extends Objective {

    public ToneObjective(){
        setMinAerobicLevel(1F);
        setMaxAerobicLevel(4F);
        setMinTrainTime(120L);
        setMaxTrainTime(150L);
    }
}
