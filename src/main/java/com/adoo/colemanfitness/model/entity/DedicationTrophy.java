package com.adoo.colemanfitness.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("dedication")
public class DedicationTrophy extends Trophy {
    public Boolean verifyTrophy(Athlete athlete) {
        // Implementación específica para VanityTrophy
        System.out.println("Verificación del trofeo Constancy.");
        // Lógica específica de verificación para VanityTrophy
        return true;
    }
}
