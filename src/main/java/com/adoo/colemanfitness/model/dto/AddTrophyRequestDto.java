package com.adoo.colemanfitness.model.dto;


import lombok.Data;

@Data
public class AddTrophyRequestDto {

    private Long userId;
    private String trophyType;

}
