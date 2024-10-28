package com.adoo.colemanfitness.controller;


import com.adoo.colemanfitness.model.dto.AddTrophyRequestDto;
import com.adoo.colemanfitness.service.TrophyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "trophy")
@AllArgsConstructor
public class TrophyController {
    private TrophyService trophyService;

    @PostMapping("/add")
    public ResponseEntity<Object> addTrophy(@RequestBody AddTrophyRequestDto request){
        return trophyService.addTrophy(request);
    }



}
