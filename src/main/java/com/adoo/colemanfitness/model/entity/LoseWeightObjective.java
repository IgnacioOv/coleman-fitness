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
}
