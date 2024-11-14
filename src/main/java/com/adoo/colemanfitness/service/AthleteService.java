package com.adoo.colemanfitness.service;


import com.adoo.colemanfitness.model.dto.*;
import com.adoo.colemanfitness.model.entity.Athlete;
import com.adoo.colemanfitness.model.entity.Trophy;
import com.adoo.colemanfitness.repository.AthleteJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AthleteService {
    private final ObjectiveService objectiveService;
    AthleteJpaRepository athleteJpaRepository;

    public ResponseEntity<Object> addAthlete(AddAthleteRequestDto request){
       try {
           Athlete athlete = new Athlete();
           athlete.setDni(request.getDni());
           athlete.setName(request.getName());
           athlete.setLastname(request.getLastname());
           athlete.setEmail(request.getEmail());
           athlete.setSex(request.getSex());
           athlete.setPassword(request.getPassword());
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


    public ResponseEntity<Object> setObjective(AddObjectiveRequestDto request){
        return objectiveService.generateRoutine(request);
    }

    public ResponseEntity<Object> login(LoginDto request) {
        Athlete athlete = athleteJpaRepository.findByEmail(request.getEmail());
        if (athlete == null) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
        if (athlete.getPassword().equals(request.getPassword())) {
            return new ResponseEntity<>("Inicio de sesión exitoso, su id es: " + athlete.getId(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contraseña incorrecta", HttpStatus.UNAUTHORIZED);
        }

    }

    public ResponseEntity<List<TrophyDto>> getAthleteTrophies(Long athleteId) {
        Athlete athlete = athleteJpaRepository.findById(athleteId)
                .orElseThrow(() -> new RuntimeException("Atleta no encontrado"));
        List<TrophyDto> trophyDtoList = new ArrayList<>();
        for (Trophy trophy : athlete.getTrophyList()) {
            trophyDtoList.add(new TrophyDto(trophy.getTrophyType()));
        }
        return new ResponseEntity<>(trophyDtoList, HttpStatus.OK);
    }

}
