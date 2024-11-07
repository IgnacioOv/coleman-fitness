package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Maintain")
public class MaintainObjective extends Objective {

    public void MaintainObjective(){
        setMinAerobicLevel(2L);
        setMaxAerobicLevel(4L);
        setMinTrainTime(45L);
        setMaxTrainTime(75L);
    }
}
