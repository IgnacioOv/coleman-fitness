package com.adoo.colemanfitness.model.dto;


import com.adoo.colemanfitness.model.entity.Routine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestTrainingDto {

    private Routine routine;
    private String muscleGroup;


}
