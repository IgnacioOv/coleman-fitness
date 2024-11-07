package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.*;
import com.adoo.colemanfitness.model.entity.*;
import com.adoo.colemanfitness.repository.ObjectiveJpaRepository;
import com.adoo.colemanfitness.repository.RoutineJpaRepository;
import com.adoo.colemanfitness.repository.TrainingExcerciseJpaRepository;
import com.adoo.colemanfitness.repository.TrainingJpaRepository;
import com.adoo.colemanfitness.util.MuscleGroupEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoutineService {


    private RoutineJpaRepository routineRepository;
    private ObjectiveJpaRepository objectiveRepository;
    private ExcerciseService excerciseService;
    private TrainingExcerciseJpaRepository trainingExcerciseJpaRepository;
    private TrainingJpaRepository trainingJpaRepository;



    private Routine createAndSaveRoutine(Objective objective) {
        Routine routine = new Routine();
        routine.setObjective(objective);
        return routineRepository.save(routine);
    }

    private List<TrainingDto> createTrainingsForRoutine(Objective objective, Routine routine) {
        List<TrainingDto> trainingList = new ArrayList<>();
        RequestExcerciseDto requestParams = buildRequestParams(objective);
        MuscleGroupEnum[] muscleGroups = MuscleGroupEnum.values();
        int totalTrainings = 12;

        for (int i = 0; i < totalTrainings; i++) {
            MuscleGroupEnum muscleGroup = muscleGroups[i % muscleGroups.length];
            requestParams.setMuscle(muscleGroup.name());
            Training training = createAndSaveTraining(routine, muscleGroup, objective.getMinTrainTime());
            List<ExcerciseDto> excerciseDtos = assignExercisesToTraining(requestParams, training);
            trainingList.add(buildTrainingDto(muscleGroup, excerciseDtos));
        }

        return trainingList;
    }

    private RequestExcerciseDto buildRequestParams(Objective objective) {
        RequestExcerciseDto requestParams = new RequestExcerciseDto();
        requestParams.setMinAerobicLevel(objective.getMinAerobicLevel());
        requestParams.setMaxAerobicLevel(objective.getMaxAerobicLevel());
        return requestParams;
    }

    private Training createAndSaveTraining(Routine routine, MuscleGroupEnum muscleGroup, Long duration) {
        Training training = new Training();
        training.setRoutine(routine);
        training.setDuration(duration);
        training.setMuscleGroup(muscleGroup.name());
        return trainingJpaRepository.save(training);
    }

    private List<ExcerciseDto> assignExercisesToTraining(RequestExcerciseDto requestParams, Training training) {
        List<Excercise> exercisesByGroup = excerciseService.getExcerciseByParameters(requestParams);
        List<ExcerciseDto> excerciseDtos = new ArrayList<>();

        for (Excercise excercise : exercisesByGroup) {
            TrainingExcercise trainingExcercise = createAndSaveTrainingExcercise(excercise, training);
            excerciseDtos.add(buildExcerciseDto(trainingExcercise));
        }

        return excerciseDtos;
    }

    private TrainingExcercise createAndSaveTrainingExcercise(Excercise excercise, Training training) {
        TrainingExcercise trainingExcercise = new TrainingExcercise();
        trainingExcercise.setExcercise(excercise);
        trainingExcercise.setTraining(training);
        trainingExcercise.setSets(3L);
        trainingExcercise.setReps(8L);
        trainingExcercise.setWeight(50.5F);
        return trainingExcerciseJpaRepository.save(trainingExcercise);
    }

    private ExcerciseDto buildExcerciseDto(TrainingExcercise trainingExcercise) {
        Excercise excercise = trainingExcercise.getExcercise();
        ExcerciseDto excerciseDto = new ExcerciseDto();
        excerciseDto.setName(excercise.getName());
        excerciseDto.setReps(trainingExcercise.getReps());
        excerciseDto.setSets(trainingExcercise.getSets());
        excerciseDto.setWeight(trainingExcercise.getWeight());
        return excerciseDto;
    }

    private TrainingDto buildTrainingDto(MuscleGroupEnum muscleGroup, List<ExcerciseDto> excerciseDtos) {
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setMuscle(muscleGroup.name());
        trainingDto.setExcerciseList(excerciseDtos);
        return trainingDto;
    }

    private ResponseEntity<Object> buildRoutineResponse(List<TrainingDto> trainingList) {
        RoutineResponseDto response = new RoutineResponseDto();
        response.setTrainingList(trainingList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    public ResponseEntity<Object> generateRoutine(Objective objective) {
        Routine routine = createAndSaveRoutine(objective);
        List<TrainingDto> trainingList = createTrainingsForRoutine(objective, routine);
        return buildRoutineResponse(trainingList);
    }





}
