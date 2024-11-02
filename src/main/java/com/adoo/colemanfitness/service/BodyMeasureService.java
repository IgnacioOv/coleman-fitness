package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddBodyMeasurementRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.BodyMeasurement;
import com.adoo.colemanfitness.repository.BodyMeasureJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BodyMeasureService {
    BodyMeasureJpaRepository bodyMeasureJpaRepository;
    public void printMessage() {
        System.out.println("¡Hola desde consola!");
    }
}
