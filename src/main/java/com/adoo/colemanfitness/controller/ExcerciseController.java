package com.adoo.colemanfitness.controller;
import com.adoo.colemanfitness.model.dto.AddExcerciseRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.service.ExcerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExcerciseController {

    @Autowired
    private ExcerciseService excerciseService;

    @GetMapping
    public List<AddExcerciseRequestDto> getAllExercises() {
        return excerciseService.getAllExercises();
    }

    @GetMapping("/{id}")
    public AddExcerciseRequestDto getExerciseById(@PathVariable Long id) {
        return excerciseService.getExerciseById(id);
    }

    @PostMapping
    public DefaultResponseDto createExercise(@RequestBody AddExcerciseRequestDto exerciseDto) {
        return excerciseService.createExercise(exerciseDto);
    }

    @PutMapping("/{id}")
    public DefaultResponseDto updateExercise(@PathVariable Long id, @RequestBody AddExcerciseRequestDto exerciseDto) {
        return excerciseService.updateExercise(id, exerciseDto);
    }

    @DeleteMapping("/{id}")
    public DefaultResponseDto deleteExercise(@PathVariable Long id) {
        return excerciseService.deleteExercise(id);
    }
}
