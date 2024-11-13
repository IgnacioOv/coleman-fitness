package com.adoo.colemanfitness.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackExcerciseDto {
    private Long id;
    private Long setsMade;
    private Long repsMade;
    private Float weightUsed;
}
