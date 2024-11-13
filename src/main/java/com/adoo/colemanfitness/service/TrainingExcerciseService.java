package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.ExcerciseDto;
import com.adoo.colemanfitness.model.dto.RequestExcerciseDto;
import com.adoo.colemanfitness.model.entity.Excercise;
import com.adoo.colemanfitness.model.entity.Training;
import com.adoo.colemanfitness.model.entity.TrainingExcercise;
import com.adoo.colemanfitness.repository.TrainingExcerciseJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TrainingExcerciseService {

    private TrainingExcerciseJpaRepository trainingExcerciseJpaRepository;
    private ExcerciseService excerciseService;

    public TrainingExcercise createAndSaveTrainingExcercise(Excercise excercise, Training training) {
        TrainingExcercise trainingExcercise = new TrainingExcercise();
        trainingExcercise.setExcercise(excercise);
        trainingExcercise.setTraining(training);
        trainingExcercise.setSets(excercise.getSets());
        trainingExcercise.setReps(excercise.getReps());
        trainingExcercise.setWeight(excercise.getWeight());
        trainingExcercise.setAssisted(false);
        return trainingExcerciseJpaRepository.save(trainingExcercise);
    }


    public List<ExcerciseDto> getExcercisesByTraining(Training training) {
        List<TrainingExcercise> trainingExcercises = training.getExcerciseList();
        List<ExcerciseDto> excerciseDtos = new ArrayList<>();

        for (TrainingExcercise trainingExcercise : trainingExcercises) {
            ExcerciseDto excerciseDto = buildExcerciseDto(trainingExcercise);
            excerciseDtos.add(excerciseDto);
        }

        return excerciseDtos;
    }


    private ExcerciseDto buildExcerciseDto(TrainingExcercise trainingExcercise) {
        Excercise excercise = trainingExcercise.getExcercise();
        ExcerciseDto excerciseDto = new ExcerciseDto();
        excerciseDto.setId(trainingExcercise.getId());
        excerciseDto.setName(excercise.getName());
        excerciseDto.setReps(trainingExcercise.getReps());
        excerciseDto.setSets(trainingExcercise.getSets());
        excerciseDto.setWeight(trainingExcercise.getWeight());
        excerciseDto.setAssisted(trainingExcercise.getAssisted());
        return excerciseDto;
    }

    public List<ExcerciseDto> assignExercisesToTraining(RequestExcerciseDto requestParams, Training training) {
        List<Excercise> exercisesByGroup = excerciseService.getExcerciseByParameters(requestParams);
        List<ExcerciseDto> excerciseDtos = new ArrayList<>();

        for (Excercise excercise : exercisesByGroup) {
            TrainingExcercise trainingExcercise = createAndSaveTrainingExcercise(excercise, training);
            excerciseDtos.add(buildExcerciseDto(trainingExcercise));
        }

        return excerciseDtos;
    }


}
