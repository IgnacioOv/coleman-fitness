package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddObjectiveRequestDto;
import com.adoo.colemanfitness.model.entity.*;
import com.adoo.colemanfitness.repository.AthleteJpaRepository;
import com.adoo.colemanfitness.repository.ObjectiveJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class ObjectiveService {
    private RoutineService routineService;
    private AthleteJpaRepository athleteJpaRepository;
    private ObjectiveJpaRepository objectiveJpaRepository;

    private Objective determineObjective(String objectiveType){
        return switch (objectiveType) {
            case "tone" -> new ToneObjective();
            case "maintain" -> new MaintainObjective();
            case "lose_weight" -> new LoseWeightObjective();
            default -> throw new IllegalArgumentException("Objetivo no valido");
        };
    }


    public ResponseEntity<Object> generateRoutine(AddObjectiveRequestDto request){
        Objective objective = determineObjective(request.getObjectiveType());
        Athlete athlete = athleteJpaRepository.findById(request.getAthleteId()).orElseThrow();
        objective.setAthlete(athlete);
        objectiveJpaRepository.save(objective);
        return routineService.generateRoutine(objective);
    }












}
