package com.adoo.colemanfitness.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModifyTrainingDto {
    private Long newSets;
    private Long newReps;
    private Long athleteId;
    private Long excerciseId;
}
