package com.adoo.colemanfitness.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddAthleteRequestDto {
    private String name;
    private String lastname;
    private String dni;
}
