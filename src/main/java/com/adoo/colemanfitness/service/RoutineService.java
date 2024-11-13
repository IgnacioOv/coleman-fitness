package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.*;
import com.adoo.colemanfitness.model.entity.*;
import com.adoo.colemanfitness.repository.RoutineJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public ResponseEntity<Object> getRoutine(Objective objective){

        List<Routine> routines = objective.getRoutines();
        Routine routine = routines.get(routines.size()-1);

        if (trainingService.checkIfFinished(routine)){
            return generateRoutine(objective);
        }
        else {
            List<TrainingDto> trainingList = trainingService.getCurrentTraining(routine);
            RoutineResponseDto response = new RoutineResponseDto();
            response.setTrainingList(trainingList);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }

    }





/*    public ResponseEntity<Object> modifySetsReps(ModifyTrainingDto request){
        try {
            ResponseEntity<Object> response = this.getRoutine(Objective );
            ArrayList<Routine> routine_raw = (ArrayList<Routine>) response.getBody();
            Routine routine = routine_raw.get(0);
            List<Training> trainingList = routine.getTrainingList();
            return new ResponseEntity<>(routine,HttpStatus.OK);
        }catch (Exception e){
            DefaultResponseDto response = new DefaultResponseDto();
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/


}
