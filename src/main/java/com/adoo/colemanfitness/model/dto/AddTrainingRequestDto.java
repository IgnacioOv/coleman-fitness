package com.adoo.colemanfitness.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTrainingRequestDto {
    private Long routineId;
    private List<Long> excerciseIds;
}
