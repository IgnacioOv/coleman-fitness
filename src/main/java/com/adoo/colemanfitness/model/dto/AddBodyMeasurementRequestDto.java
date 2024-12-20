package com.adoo.colemanfitness.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AddBodyMeasurementRequestDto {
    private Float weight;
    private Float muscleMass;
    private Float bodyFat;
    private Long height;
    private Date date;
    private Long idAthlete;
}
