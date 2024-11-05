package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddTrainingExcerciseRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.Excercise;
import com.adoo.colemanfitness.model.entity.Training;
import com.adoo.colemanfitness.model.entity.TrainingExcercise;
import com.adoo.colemanfitness.repository.ExcerciseJpaRepository;
import com.adoo.colemanfitness.repository.TrainingJpaRepository;
import com.adoo.colemanfitness.repository.TrainingExcerciseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingExcerciseService {

    @Autowired
    private TrainingExcerciseJpaRepository trainingExcerciseRepository;

    @Autowired
    private ExcerciseJpaRepository excerciseRepository;

    @Autowired
    private TrainingJpaRepository trainingRepository;

    public List<AddTrainingExcerciseRequestDto> getAllTrainingExcercises() {
        return trainingExcerciseRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AddTrainingExcerciseRequestDto getTrainingExcerciseById(Long id) {
        return trainingExcerciseRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public DefaultResponseDto createTrainingExcercise(AddTrainingExcerciseRequestDto trainingExcerciseDto) {
        TrainingExcercise trainingExcercise = convertToEntity(trainingExcerciseDto);
        trainingExcerciseRepository.save(trainingExcercise);
        return new DefaultResponseDto("Training excercise created successfully", HttpStatus.CREATED);
    }

    public DefaultResponseDto updateTrainingExcercise(Long id, AddTrainingExcerciseRequestDto trainingExcerciseDto) {
        TrainingExcercise trainingExcercise = trainingExcerciseRepository.findById(id).orElse(null);
        if (trainingExcercise != null) {
            trainingExcercise.setReps(trainingExcerciseDto.getReps());
            trainingExcercise.setSets(trainingExcerciseDto.getSets());
            trainingExcercise.setWeight(trainingExcerciseDto.getWeight());

            // Actualizar relaciones de Excercise y Training si es necesario
            if (trainingExcerciseDto.getExcerciseId() != null) {
                Excercise excercise = excerciseRepository.findById(trainingExcerciseDto.getExcerciseId()).orElse(null);
                trainingExcercise.setExcercise(excercise);
            }
            if (trainingExcerciseDto.getTrainingId() != null) {
                Training training = trainingRepository.findById(trainingExcerciseDto.getTrainingId()).orElse(null);
                trainingExcercise.setTraining(training);
            }

            trainingExcerciseRepository.save(trainingExcercise);
            return new DefaultResponseDto("Training excercise updated successfully", HttpStatus.OK);
        }
        return new DefaultResponseDto("Training excercise not found", HttpStatus.NOT_FOUND);
    }

    public DefaultResponseDto deleteTrainingExcercise(Long id) {
        if (trainingExcerciseRepository.existsById(id)) {
            trainingExcerciseRepository.deleteById(id);
            return new DefaultResponseDto("Training excercise deleted successfully", HttpStatus.OK);
        } else {
            return new DefaultResponseDto("Training excercise not found", HttpStatus.NOT_FOUND);
        }
    }

    private AddTrainingExcerciseRequestDto convertToDto(TrainingExcercise trainingExcercise) {
        return new AddTrainingExcerciseRequestDto(
                trainingExcercise.getReps(),
                trainingExcercise.getSets(),
                trainingExcercise.getWeight(),
                trainingExcercise.getExcercise() != null ? trainingExcercise.getExcercise().getId() : null,
                trainingExcercise.getTraining() != null ? trainingExcercise.getTraining().getId() : null
        );
    }

    private TrainingExcercise convertToEntity(AddTrainingExcerciseRequestDto trainingExcerciseDto) {
        TrainingExcercise trainingExcercise = new TrainingExcercise();
        trainingExcercise.setReps(trainingExcerciseDto.getReps());
        trainingExcercise.setSets(trainingExcerciseDto.getSets());
        trainingExcercise.setWeight(trainingExcerciseDto.getWeight());

        if (trainingExcerciseDto.getExcerciseId() != null) {
            Excercise excercise = excerciseRepository.findById(trainingExcerciseDto.getExcerciseId()).orElse(null);
            trainingExcercise.setExcercise(excercise);
        }
        if (trainingExcerciseDto.getTrainingId() != null) {
            Training training = trainingRepository.findById(trainingExcerciseDto.getTrainingId()).orElse(null);
            trainingExcercise.setTraining(training);
        }

        return trainingExcercise;
    }
}
