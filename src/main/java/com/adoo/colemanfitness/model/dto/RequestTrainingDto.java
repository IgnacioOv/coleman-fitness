package com.adoo.colemanfitness.model.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RequestTrainingDto {

    private Long minAerobicLevel;
    private Long maxAerobicLevel;
    private Long minTrainingTime;
    private Long maxTrainingTime;


}
