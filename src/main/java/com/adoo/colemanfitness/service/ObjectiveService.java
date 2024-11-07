package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddObjectiveRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.*;
import com.adoo.colemanfitness.repository.AthleteJpaRepository;
import com.adoo.colemanfitness.repository.ObjectiveJpaRepository;
import com.adoo.colemanfitness.repository.RoutineJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectiveService {
    RoutineJpaRepository routineJpaRepository

    private Objective determineObjective(String objectiveType){
        return switch (objectiveType) {
            case "tone" -> new ToneObjective();
            case "maintain" -> new MaintainObjective();
            case "lose_weight" -> new LoseWeightObjective();
            default -> throw new IllegalArgumentException("Objetivo no valido");
        };
    }

    public DefaultResponseDto createObjective(AddObjectiveRequestDto request) {
        try{
            DefaultResponseDto response = new DefaultResponseDto();
            response.setCode(HttpStatus.OK);
            response.setMessage("Usuario guardado exitosamente");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e){
            DefaultResponseDto response = new DefaultResponseDto();
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Objective objective = convertToEntity(objectiveDto);
        objectiveRepository.save(objective);
        return new DefaultResponseDto("Objective created successfully", HttpStatus.CREATED);
    }


    public ResponseEntity<Object> generateRoutine(String objectiveType){

       try {
           Routine routine = new Routine();
           routineJpaRepository.save(routine);
           Objective objective = determineObjective(objectiveType);


       }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }





}
