package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddObjectiveRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.*;
import com.adoo.colemanfitness.repository.AthleteJpaRepository;
import com.adoo.colemanfitness.repository.ObjectiveJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectiveService {


    private Objective determineObjective(String objectiveType){
        return switch (objectiveType) {
            case "tone" -> new ToneObjective();
            case "maintain" -> new MaintainObjective();
            case "lose_weight" -> new LoseWeightObjective();
            default -> throw new IllegalArgumentException("Objetivo no valido");
        };
    }

    public ResponseEntity<Object> generateRoutine(String objectiveType){

       try {
          Objective objective = determineObjective(objectiveType);


       }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }





}
