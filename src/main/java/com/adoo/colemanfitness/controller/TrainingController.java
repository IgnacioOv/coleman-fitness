package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.dto.AddTrainingRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping
    public List<AddTrainingRequestDto> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

    @GetMapping("/{id}")
    public AddTrainingRequestDto getTrainingById(@PathVariable Long id) {
        return trainingService.getTrainingById(id);
    }

    @PostMapping
    public DefaultResponseDto createTraining(@RequestBody AddTrainingRequestDto trainingDto) {
        return trainingService.createTraining(trainingDto);
    }

    @PutMapping("/{id}")
    public DefaultResponseDto updateTraining(@PathVariable Long id, @RequestBody AddTrainingRequestDto trainingDto) {
        return trainingService.updateTraining(id, trainingDto);
    }

    @DeleteMapping("/{id}")
    public DefaultResponseDto deleteTraining(@PathVariable Long id) {
        return trainingService.deleteTraining(id);
    }
}
