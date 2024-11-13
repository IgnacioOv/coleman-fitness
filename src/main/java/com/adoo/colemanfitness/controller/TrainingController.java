package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.service.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/start/{trainingId}")
    public ResponseEntity<Object> startTraining(@PathVariable Long trainingId) {
        return trainingService.startTraining(trainingId);

    }
}
