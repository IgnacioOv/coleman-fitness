package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("constancy")
public class ConstancyTrophy extends Trophy {
    public Boolean verifyTrophy(Athlete athlete) {return true;};
}
