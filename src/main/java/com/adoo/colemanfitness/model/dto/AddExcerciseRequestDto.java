package com.adoo.colemanfitness.model.dto;

import com.adoo.colemanfitness.util.MuscleGroupEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddExcerciseRequestDto {
    private String name;
    private MuscleGroupEnum muscleGroup;
    private Float aerobicLevel;
    private String video;
}
