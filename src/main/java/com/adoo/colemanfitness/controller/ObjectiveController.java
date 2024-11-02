package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.dto.AddObjectiveRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.service.ObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objectives")
public class ObjectiveController {

    @Autowired
    private ObjectiveService objectiveService;

    @GetMapping
    public List<AddObjectiveRequestDto> getAllObjectives() {
        return objectiveService.getAllObjectives();
    }

    @GetMapping("/{id}")
    public AddObjectiveRequestDto getObjectiveById(@PathVariable Long id) {
        return objectiveService.getObjectiveById(id);
    }

    @PostMapping
    public DefaultResponseDto createObjective(@RequestBody AddObjectiveRequestDto objectiveDto) {
        return objectiveService.createObjective(objectiveDto);
    }

    @PutMapping("/{id}")
    public DefaultResponseDto updateObjective(@PathVariable Long id, @RequestBody AddObjectiveRequestDto objectiveDto) {
        return objectiveService.updateObjective(id, objectiveDto);
    }

    @DeleteMapping("/{id}")
    public DefaultResponseDto deleteObjective(@PathVariable Long id) {
        return objectiveService.deleteObjective(id);
    }
}
