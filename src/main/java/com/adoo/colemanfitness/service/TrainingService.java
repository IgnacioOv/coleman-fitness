package com.adoo.colemanfitness.service;
import com.adoo.colemanfitness.model.dto.*;
import com.adoo.colemanfitness.model.entity.Objective;
import com.adoo.colemanfitness.model.entity.Routine;
import com.adoo.colemanfitness.model.entity.Training;
import com.adoo.colemanfitness.repository.TrainingJpaRepository;
import com.adoo.colemanfitness.util.MuscleGroupEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TrainingService {


    private TrainingJpaRepository trainingJpaRepository;
    private TrainingExcerciseService trainingExcerciseService;

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
            trainingList.add(buildTrainingDto(muscleGroup, excerciseDtos));
        }

        return trainingList;
    }


    private Training createAndSaveTraining(Routine routine, MuscleGroupEnum muscleGroup, Long duration) {
        Training training = new Training();
        training.setRoutine(routine);
        training.setDuration(duration);
        training.setMuscleGroup(muscleGroup.name());
        return trainingJpaRepository.save(training);
    }

    private TrainingDto buildTrainingDto(MuscleGroupEnum muscleGroup, List<ExcerciseDto> excerciseDtos) {
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setMuscle(muscleGroup.name());
        trainingDto.setExcerciseList(excerciseDtos);
        return trainingDto;
    }


}
