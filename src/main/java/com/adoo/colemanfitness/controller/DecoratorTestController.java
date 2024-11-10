package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.dto.RequestExcerciseDto;
import com.adoo.colemanfitness.service.ExcerciseDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/decorator")
public class DecoratorTestController {
    private final ExcerciseDecorator excerciseDecorator;

    @Autowired
    public DecoratorTestController(ExcerciseDecorator excerciseDecorator) {
        this.excerciseDecorator = excerciseDecorator;
    }

    @PostMapping("/get")
    public ResponseEntity<List> testDecorator(@RequestBody RequestExcerciseDto request){
        return new ResponseEntity<> (excerciseDecorator.getExcerciseByParameters(request), HttpStatus.OK);
    }
}
