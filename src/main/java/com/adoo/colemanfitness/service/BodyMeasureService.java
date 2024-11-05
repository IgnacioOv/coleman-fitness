package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddBodyMeasurementRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.Athlete;
import com.adoo.colemanfitness.model.entity.BodyMeasurement;
import com.adoo.colemanfitness.repository.AthleteJpaRepository;
import com.adoo.colemanfitness.repository.BodyMeasureJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BodyMeasureService {
    BodyMeasureJpaRepository bodyMeasureJpaRepository;
    AthleteJpaRepository athleteJpaRepository;
    private TrophyService trophyService;
    public String printMessage() {
        return "wasssaaaaaaaaa";
    }
    public ResponseEntity<Object> addMesurment(AddBodyMeasurementRequestDto request){
        try{
            BodyMeasurement bodyMeasurement = new BodyMeasurement();
            bodyMeasurement.setBodyFat(request.getBodyFat());
            bodyMeasurement.setDate(request.getDate());
            bodyMeasurement.setWeight(request.getWeight());
            bodyMeasurement.setMuscleMass(request.getMuscleMass());
            bodyMeasurement.setHeight(request.getHeight());
            Athlete athlete = athleteJpaRepository.findById(request.getIdAthlete()).orElseThrow();
            bodyMeasurement.setAthlete(athlete);
            bodyMeasureJpaRepository.save(bodyMeasurement);
            DefaultResponseDto response = new DefaultResponseDto();
            response.setCode(HttpStatus.OK);
            response.setMessage("Medidas guardadas exitosamente");
            Long athleteId = request.getIdAthlete();
            trophyService.verify("vanity", athleteId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e){
            DefaultResponseDto response = new DefaultResponseDto();
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
