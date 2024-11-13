package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.dto.AddObjectiveRequestDto;
import com.adoo.colemanfitness.service.ObjectiveService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/objectives")
@AllArgsConstructor
public class ObjectiveController {

    private final ObjectiveService objectiveService;

    @PostMapping("/assign")
    public ResponseEntity<Object> assignObjective(@RequestBody AddObjectiveRequestDto request) {
        return objectiveService.generateRoutine(request);
    }

   @GetMapping("/current/{athleteId}")
    public ResponseEntity<Object> getCurrentObjective(@PathVariable Long athleteId) {
        return objectiveService.getCurrentRoutine(athleteId);
    }

}
