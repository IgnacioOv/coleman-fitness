package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.*;
import com.adoo.colemanfitness.model.entity.Objective;
import com.adoo.colemanfitness.model.entity.Routine;
import com.adoo.colemanfitness.model.entity.Training;
import com.adoo.colemanfitness.repository.TrainingJpaRepository;
import com.adoo.colemanfitness.util.MuscleGroupEnum;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TrainingService {

    private final TrainingJpaRepository trainingJpaRepository;
    private final TrainingExcerciseService trainingExcerciseService;

    private RequestExcerciseDto buildRequestParams(Objective objective) {
        RequestExcerciseDto requestParams = new RequestExcerciseDto();
        requestParams.setMinAerobicLevel(objective.getMinAerobicLevel());
        requestParams.setMaxAerobicLevel(objective.getMaxAerobicLevel());
        return requestParams;
    }

    public List<TrainingDto> createTrainingsForRoutine(Objective objective, Routine routine) {
        List<TrainingDto> trainingList = new ArrayList<>();
        RequestExcerciseDto requestParams = buildRequestParams(objective);
        MuscleGroupEnum[] muscleGroups = MuscleGroupEnum.values();
        int totalTrainings = 12;

        for (int i = 0; i < totalTrainings; i++) {
            MuscleGroupEnum muscleGroup = muscleGroups[i % muscleGroups.length];
            requestParams.setMuscle(muscleGroup.name());
            Training training = createAndSaveTraining(routine, muscleGroup, objective.getMinTrainTime());
            List<ExcerciseDto> excerciseDtos = trainingExcerciseService.assignExercisesToTraining(requestParams, training);
            trainingList.add(buildTrainingDto(training, excerciseDtos));
        }
        return trainingList;
    }

    private Training createAndSaveTraining(Routine routine, MuscleGroupEnum muscleGroup, Long duration) {
        Training training = new Training();
        training.setRoutine(routine);
        training.setDuration(duration);
        training.setMuscleGroup(muscleGroup.name());
        training.setAssisted(false);
        return trainingJpaRepository.save(training);
    }


    public List<TrainingDto> getCurrentTraining(Routine routine){
        List<Training> trainingList = routine.getTrainingList();
        List<TrainingDto> response = new ArrayList<>();
        for(Training training : trainingList){
            TrainingDto trainingDto = buildTrainingDto(training, trainingExcerciseService.getExcercisesByTraining(training));
            List<ExcerciseDto> excerciseDtos = trainingExcerciseService.getExcercisesByTraining(training);
            trainingDto.setExcerciseList(excerciseDtos);
            response.add(trainingDto);
        }
        return response;

    }

    private TrainingDto buildTrainingDto(Training training, List<ExcerciseDto> excerciseDtos) {
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setTrainingId(training.getId());
        trainingDto.setMuscle(training.getMuscleGroup());
        trainingDto.setExcerciseList(excerciseDtos);
        trainingDto.setAssisted(training.getAssisted());
        return trainingDto;
    }

    public ResponseEntity<Object> startTraining(Long trainingId) {
        try {
            Training training = trainingJpaRepository.findById(trainingId)
                    .orElseThrow(() -> new RuntimeException("Entrenamiento no encontrado"));
            if (!training.getAssisted()) {
                training.setAssisted(true);
                trainingJpaRepository.save(training);

            } else {
                throw new RuntimeException("Entrenamiento ya asistido");
            }
            return new ResponseEntity<>("Buen entrenamiento!",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public Boolean checkIfFinished(Routine routine){
        List<Training> trainingList = routine.getTrainingList();
        for (Training training: trainingList){
            if(!training.getAssisted()){
                return false;
            }
        }
        return true;
    }

}
