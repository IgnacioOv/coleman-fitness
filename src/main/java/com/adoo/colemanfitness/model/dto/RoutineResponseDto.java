package com.adoo.colemanfitness.model.dto;

import com.adoo.colemanfitness.model.entity.Training;
import com.adoo.colemanfitness.model.entity.TrainingExcercise;
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
