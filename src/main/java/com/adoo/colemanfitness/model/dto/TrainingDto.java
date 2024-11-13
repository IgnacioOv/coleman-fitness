package com.adoo.colemanfitness.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrainingDto {
    private Long trainingId;
    private String muscle;
    private List<ExcerciseDto> excerciseList;
    private Boolean assisted;

}
