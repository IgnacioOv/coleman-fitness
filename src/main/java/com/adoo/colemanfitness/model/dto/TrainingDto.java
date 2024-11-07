package com.adoo.colemanfitness.model.dto;


import com.adoo.colemanfitness.model.entity.TrainingExcercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrainingDto {
    private String muscle;
    private List<ExcerciseDto> excerciseList;

}
