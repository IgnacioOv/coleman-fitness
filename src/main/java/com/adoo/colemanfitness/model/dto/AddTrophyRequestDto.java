package com.adoo.colemanfitness.model.dto;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class AddTrophyRequestDto {

    private Long userId;
    private String trophyType;

}
