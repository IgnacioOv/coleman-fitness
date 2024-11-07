package com.adoo.colemanfitness.service;
import com.adoo.colemanfitness.model.dto.AddTrainingRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.dto.RequestTrainingDto;
import com.adoo.colemanfitness.model.entity.Routine;
import com.adoo.colemanfitness.model.entity.Training;
import com.adoo.colemanfitness.model.entity.TrainingExcercise;
import com.adoo.colemanfitness.repository.RoutineJpaRepository;
import com.adoo.colemanfitness.repository.TrainingJpaRepository;
import com.adoo.colemanfitness.repository.TrainingExcerciseJpaRepository;
import com.adoo.colemanfitness.util.MuscleGroupEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingService {

    @Autowired
    private TrainingJpaRepository trainingRepository;

    @Autowired
    private RoutineJpaRepository routineRepository;

    @Autowired
    private TrainingExcerciseJpaRepository trainingExcerciseRepository;
    @Autowired
    private ExcerciseService excerciseService;
    @Autowired
    private TrainingExcerciseService trainingExcerciseService;

    public List<AddTrainingRequestDto> getAllTrainings() {
        return trainingRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AddTrainingRequestDto getTrainingById(Long id) {
        return trainingRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public DefaultResponseDto createTraining(AddTrainingRequestDto trainingDto) {
        Training training = convertToEntity(trainingDto);
        trainingRepository.save(training);
        return new DefaultResponseDto("Training created successfully", HttpStatus.CREATED);
    }

    public DefaultResponseDto updateTraining(Long id, AddTrainingRequestDto trainingDto) {
        Training training = trainingRepository.findById(id).orElse(null);
        if (training != null) {
            if (trainingDto.getRoutineId() != null) {
                Routine routine = routineRepository.findById(trainingDto.getRoutineId()).orElse(null);
                training.setRoutine(routine);
            }

            if (trainingDto.getExcerciseIds() != null) {
                List<TrainingExcercise> excercises = trainingDto.getExcerciseIds().stream()
                        .map(trainingExcerciseRepository::findById)
                        .filter(java.util.Optional::isPresent)
                        .map(java.util.Optional::get)
                        .collect(Collectors.toList());
                training.setExcerciseList(excercises);
            }

            trainingRepository.save(training);
            return new DefaultResponseDto("Training updated successfully", HttpStatus.OK);
        }
        return new DefaultResponseDto("Training not found", HttpStatus.NOT_FOUND);
    }

    public DefaultResponseDto deleteTraining(Long id) {
        if (trainingRepository.existsById(id)) {
            trainingRepository.deleteById(id);
            return new DefaultResponseDto("Training deleted successfully", HttpStatus.OK);
        }
        return new DefaultResponseDto("Training not found", HttpStatus.NOT_FOUND);
    }

    private AddTrainingRequestDto convertToDto(Training training) {
        List<Long> excerciseIds = training.getExcerciseList().stream()
                .map(TrainingExcercise::getId)
                .collect(Collectors.toList());
        return new AddTrainingRequestDto(
                training.getRoutine() != null ? training.getRoutine().getId() : null,
                excerciseIds
        );
    }

    private Training convertToEntity(AddTrainingRequestDto trainingDto) {
        Training training = new Training();

        if (trainingDto.getRoutineId() != null) {
            Routine routine = routineRepository.findById(trainingDto.getRoutineId()).orElse(null);
            training.setRoutine(routine);
        }

        if (trainingDto.getExcerciseIds() != null) {
            List<TrainingExcercise> excercises = trainingDto.getExcerciseIds().stream()
                    .map(trainingExcerciseRepository::findById)
                    .filter(java.util.Optional::isPresent)
                    .map(java.util.Optional::get)
                    .collect(Collectors.toList());
            training.setExcerciseList(excercises);
        }

        return training;
    }







}
