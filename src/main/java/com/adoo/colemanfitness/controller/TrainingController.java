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

    @PostMapping("/{trainingId}/track-exercise")
    public ResponseEntity<Object> trackExercise(
            @PathVariable Long trainingId,
            @RequestParam Long exerciseId,
            @RequestParam Long sets,
            @RequestParam Long reps,
            @RequestParam Float weight,
            @RequestParam Boolean assisted) { // Añadir el parámetro assisted

        trainingService.trackExercise(trainingId, exerciseId, sets, reps, weight, assisted);

        return ResponseEntity.ok("Ejercicio rastreado exitosamente");
    }
}
