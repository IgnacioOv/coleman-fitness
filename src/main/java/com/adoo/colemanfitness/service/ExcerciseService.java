package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddExcerciseRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.Excercise;
import com.adoo.colemanfitness.repository.ExcerciseJpaRepository;
import com.adoo.colemanfitness.util.MuscleGroupEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExcerciseService {

    @Autowired
    private ExcerciseJpaRepository excerciseJpaRepository;

    public List<AddExcerciseRequestDto> getAllExercises() {
        return excerciseJpaRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AddExcerciseRequestDto getExerciseById(Long id) {
        return excerciseJpaRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public DefaultResponseDto createExercise(AddExcerciseRequestDto excerciseDto) {
        Excercise excercise = convertToEntity(excerciseDto);
        excerciseJpaRepository.save(excercise);
        return new DefaultResponseDto("Exercise created successfully", HttpStatus.CREATED);
    }

    public DefaultResponseDto updateExercise(Long id, AddExcerciseRequestDto excerciseDto) {
        Excercise excercise = excerciseJpaRepository.findById(id).orElse(null);
        if (excercise != null) {
            excercise.setName(excerciseDto.getName());
            excercise.setMuscleGroup(excerciseDto.getMuscleGroup().name());
            excercise.setAerobicLevel(excerciseDto.getAerobicLevel());
            excercise.setVideo(excerciseDto.getVideo());
            excerciseJpaRepository.save(excercise);
            return new DefaultResponseDto("Exercise updated successfully", HttpStatus.OK);
        }
        return new DefaultResponseDto("Exercise not found", HttpStatus.NOT_FOUND);
    }

    public DefaultResponseDto deleteExercise(Long id) {
        if (excerciseJpaRepository.existsById(id)) {
            excerciseJpaRepository.deleteById(id);
            return new DefaultResponseDto("Exercise deleted successfully", HttpStatus.OK);
        } else {
            return new DefaultResponseDto("Exercise not found", HttpStatus.NOT_FOUND);
        }
    }

    private AddExcerciseRequestDto convertToDto(Excercise excercise) {
        return new AddExcerciseRequestDto(
                excercise.getName(),
                MuscleGroupEnum.valueOf(excercise.getMuscleGroup()),
                excercise.getAerobicLevel(),
                excercise.getVideo()
        );
    }

    private Excercise convertToEntity(AddExcerciseRequestDto excerciseDto) {
        return new Excercise(
                null,
                excerciseDto.getName(),
                excerciseDto.getMuscleGroup().name(),
                excerciseDto.getAerobicLevel(),
                excerciseDto.getVideo(),
                null
        );
    }
}
