package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.dto.AddBodyMeasurementRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.BodyMeasurement;
import com.adoo.colemanfitness.repository.BodyMeasureJpaRepository;
import com.adoo.colemanfitness.service.BodyMeasureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping("bodyMeasurements")

public class BodyMeasurementController {
    private final BodyMeasureService bodyMeasureService;
    @Autowired
    public BodyMeasurementController(BodyMeasureService bodyMeasureService) {
        this.bodyMeasureService = bodyMeasureService;
    }
    @GetMapping("/imprimir")
    public String imprimir() {
        return bodyMeasureService.printMessage();
    }
}
