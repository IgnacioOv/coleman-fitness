package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Lose_weight")
public class LoseWeightObjective extends Objective {
    public void MaintainObjective(){
        setMinAerobicLevel(3L);
        setMaxAerobicLevel(10L);
        setMinTrainTime(60L);
        setMaxTrainTime(90L);
    }
}
