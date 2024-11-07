package com.adoo.colemanfitness.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestExcerciseDto {
    private String muscle;
    private Float minAerobicLevel;
    private Float maxAerobicLevel;
}
