package com.adoo.colemanfitness.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RoutineResponseDto {

    private List<TrainingDto> trainingList;
}
