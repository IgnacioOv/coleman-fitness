package com.adoo.colemanfitness.service;


import com.adoo.colemanfitness.model.dto.AddAthleteRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.Athlete;
import com.adoo.colemanfitness.repository.AthleteJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AthleteService {
    AthleteJpaRepository athleteJpaRepository;

    public ResponseEntity<Object> addAthlete(AddAthleteRequestDto request){
       try {
           Athlete athlete = new Athlete();
           athlete.setDni(request.getDni());
           athlete.setName(request.getName());
           athlete.setLastname(request.getLastname());
           athleteJpaRepository.save(athlete);
           DefaultResponseDto response = new DefaultResponseDto();
           response.setCode(HttpStatus.OK);
           response.setMessage("Usuario guardado exitosamente");
           return new ResponseEntity<>(response,HttpStatus.OK);
       }catch (Exception e){
           DefaultResponseDto response = new DefaultResponseDto();
           response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
           response.setMessage(e.getMessage());
           return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    public ResponseEntity<Object> getAthletes(){
        try {
            List<Athlete> athletes = athleteJpaRepository.findAll();
            return new ResponseEntity<>(athletes,HttpStatus.OK);
        }catch (Exception e){
            DefaultResponseDto response = new DefaultResponseDto();
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Object> getAthleteId(Long id){
        try {
            Athlete athlete = athleteJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Atleta no encontrado"));
            return new ResponseEntity<>(athlete,HttpStatus.OK);
        }catch (Exception e){
            DefaultResponseDto response = new DefaultResponseDto();
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
