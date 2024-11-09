package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.dto.AddBodyMeasurementRequestDto;
import com.adoo.colemanfitness.service.BodyMeasureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping("bodyMeasurements")

public class BodyMeasurementController {
    private final BodyMeasureService bodyMeasureService;
    @Autowired
    public BodyMeasurementController(BodyMeasureService bodyMeasureService) {
        this.bodyMeasureService = bodyMeasureService;
    }
    @PostMapping("/addMeasurement")
    public ResponseEntity<Object> addMeasurement(@RequestBody AddBodyMeasurementRequestDto request){
        return bodyMeasureService.addMeasurement(request);
    }
}
