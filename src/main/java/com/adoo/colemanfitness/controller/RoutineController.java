package com.adoo.colemanfitness.controller;


import com.adoo.colemanfitness.model.dto.ModifyTrainingDto;
import com.adoo.colemanfitness.service.RoutineService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routines")
@AllArgsConstructor
public class RoutineController {

    RoutineService routineService;

/*    @GetMapping("/modifyExercise")
    public ResponseEntity<Object> modifyExercise(@RequestBody ModifyTrainingDto request){
        return routineService.modifySetsReps(request);
    }*/
}
