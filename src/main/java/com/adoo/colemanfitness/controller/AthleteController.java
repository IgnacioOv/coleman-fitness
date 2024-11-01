package com.adoo.colemanfitness.controller;


import com.adoo.colemanfitness.model.dto.AddAthleteRequestDto;
import com.adoo.colemanfitness.service.AthleteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("athlete")
@AllArgsConstructor
public class AthleteController {

    AthleteService athleteService;

    @PostMapping("/add")
    public ResponseEntity<Object> addAthlete(@RequestBody AddAthleteRequestDto request){
        return athleteService.addAthlete(request);
    }
}
