package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.dto.TrackExcerciseDto;
import com.adoo.colemanfitness.service.TrainingExcerciseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/training-exercises")
@AllArgsConstructor
public class TrainingExcerciseController {

    TrainingExcerciseService trainingExcerciseService;


    @PostMapping("/track")
    public ResponseEntity<Object> trackExcercise(@RequestBody TrackExcerciseDto request){
        return trainingExcerciseService.trackExcercise(request);
    }

}
