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
    private Long minAerobicLevel = 1L;
    private Long maxAerobicLevel = 4L;
    private Long minTrainTime = 120L;
    private Long maxTrainTime = 150L;
}
