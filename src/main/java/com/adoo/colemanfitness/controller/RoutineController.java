package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.dto.AddRoutineRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routines")
public class RoutineController {

    @Autowired
    private RoutineService routineService;

    @GetMapping
    public List<AddRoutineRequestDto> getAllRoutines() {
        return routineService.getAllRoutines();
    }

    @GetMapping("/{id}")
    public AddRoutineRequestDto getRoutineById(@PathVariable Long id) {
        return routineService.getRoutineById(id);
    }

    @PostMapping
    public DefaultResponseDto createRoutine(@RequestBody AddRoutineRequestDto routineDto) {
        return routineService.createRoutine(routineDto);
    }

    @PutMapping("/{id}")
    public DefaultResponseDto updateRoutine(@PathVariable Long id, @RequestBody AddRoutineRequestDto routineDto) {
        return routineService.updateRoutine(id, routineDto);
    }

    @DeleteMapping("/{id}")
    public DefaultResponseDto deleteRoutine(@PathVariable Long id) {
        return routineService.deleteRoutine(id);
    }
}
