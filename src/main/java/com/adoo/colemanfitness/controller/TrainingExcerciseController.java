package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.dto.AddTrainingExcerciseRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.service.TrainingExcerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-exercises")
public class TrainingExcerciseController {

    @Autowired
    private TrainingExcerciseService trainingExcerciseService;

    @GetMapping
    public List<AddTrainingExcerciseRequestDto> getAllTrainingExcercises() {
        return trainingExcerciseService.getAllTrainingExcercises();
    }

    @GetMapping("/{id}")
    public AddTrainingExcerciseRequestDto getTrainingExcerciseById(@PathVariable Long id) {
        return trainingExcerciseService.getTrainingExcerciseById(id);
    }

    @PostMapping
    public DefaultResponseDto createTrainingExcercise(@RequestBody AddTrainingExcerciseRequestDto trainingExcerciseDto) {
        return trainingExcerciseService.createTrainingExcercise(trainingExcerciseDto);
    }

    @PutMapping("/{id}")
    public DefaultResponseDto updateTrainingExcercise(@PathVariable Long id, @RequestBody AddTrainingExcerciseRequestDto trainingExcerciseDto) {
        return trainingExcerciseService.updateTrainingExcercise(id, trainingExcerciseDto);
    }

    @DeleteMapping("/{id}")
    public DefaultResponseDto deleteTrainingExcercise(@PathVariable Long id) {
        return trainingExcerciseService.deleteTrainingExcercise(id);
    }
}
