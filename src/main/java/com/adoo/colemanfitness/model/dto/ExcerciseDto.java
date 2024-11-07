package com.adoo.colemanfitness.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcerciseDto {
    private String name;
    private Long reps;
    private Long sets;
    private Float weight;
}