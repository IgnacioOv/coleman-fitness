package com.adoo.colemanfitness.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectiveMeasurementDto {
    private Long weight;
    private Float muscleMass;
    private Float bodyFat;

}
