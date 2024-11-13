package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddObjectiveRequestDto;
import com.adoo.colemanfitness.model.dto.RoutineResponseDto;
import com.adoo.colemanfitness.model.entity.*;
import com.adoo.colemanfitness.repository.AthleteJpaRepository;
import com.adoo.colemanfitness.repository.ObjectiveJpaRepository;
import com.adoo.colemanfitness.repository.ObjectiveMeasurementJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ObjectiveService {
    private RoutineService routineService;
    private AthleteJpaRepository athleteJpaRepository;
    private ObjectiveJpaRepository objectiveJpaRepository;
    private ObjectiveMeasurementJpaRepository objectiveMeasurementJpaRepository;

    private Objective determineObjective(String objectiveType){
        return switch (objectiveType) {
            case "tone" -> new ToneObjective();
            case "maintain" -> new MaintainObjective();
            case "lose_weight" -> new LoseWeightObjective();
            default -> throw new IllegalArgumentException("Objetivo no valido");
        };
    }


    private void calculateObjectiveMeasurement(Objective objective){
        Athlete athlete = objective.getAthlete();
        List<BodyMeasurement> measurements = athlete.getBodyMeasurementList();
        BodyMeasurement measurement =  measurements.get(measurements.size()-1);
        ObjectiveMeasurement objectiveMeasurement = objective.calculateObjectiveMeasurements(measurement);
        objectiveMeasurement.setObjective(objective);
        objectiveMeasurementJpaRepository.save(objectiveMeasurement);
    }


    public ResponseEntity<Object> generateRoutine(AddObjectiveRequestDto request){
        Objective objective = determineObjective(request.getObjectiveType());
        Athlete athlete = athleteJpaRepository.findById(request.getAthleteId()).orElseThrow();
        objective.setAthlete(athlete);
        objectiveJpaRepository.save(objective);
        calculateObjectiveMeasurement(objective);
        return routineService.generateRoutine(objective);
    }


    public ResponseEntity<Object> getCurrentRoutine(Long athleteId){
        Athlete athlete = athleteJpaRepository.findById(athleteId).orElseThrow();
        List<Objective> objectives = athlete.getObjectives();
        Objective objective = objectives.get(objectives.size()-1);

        return routineService.getRoutine(objective);
    }


}
