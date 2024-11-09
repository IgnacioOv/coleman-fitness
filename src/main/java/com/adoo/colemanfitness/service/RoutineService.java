package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.*;
import com.adoo.colemanfitness.model.entity.*;
import com.adoo.colemanfitness.repository.RoutineJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class RoutineService {


    private RoutineJpaRepository routineRepository;
    private TrainingService trainingService;

    private Routine createAndSaveRoutine(Objective objective) {
        Routine routine = new Routine();
        routine.setObjective(objective);
        return routineRepository.save(routine);
    }


    private ResponseEntity<Object> buildRoutineResponse(List<TrainingDto> trainingList) {
        RoutineResponseDto response = new RoutineResponseDto();
        response.setTrainingList(trainingList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    public ResponseEntity<Object> generateRoutine(Objective objective) {
        Routine routine = createAndSaveRoutine(objective);
        List<TrainingDto> trainingList = trainingService.createTrainingsForRoutine(objective, routine);
        return buildRoutineResponse(trainingList);
    }


}
