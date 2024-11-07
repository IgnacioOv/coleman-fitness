package com.adoo.colemanfitness.controller;
import com.adoo.colemanfitness.model.dto.AddExcerciseRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.dto.RequestExcerciseDto;
import com.adoo.colemanfitness.service.ExcerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/excercise")
public class ExcerciseController {

    @Autowired
    private ExcerciseService excerciseService;

    @PostMapping("/get")
    public ResponseEntity<Object> getExcerciseByParameters(@RequestBody RequestExcerciseDto request){
        return new ResponseEntity<>(excerciseService.getExcerciseByParameters(request), HttpStatus.OK);
    }
}
