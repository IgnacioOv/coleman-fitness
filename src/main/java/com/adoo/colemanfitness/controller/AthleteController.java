package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.dto.AddAthleteRequestDto;
import com.adoo.colemanfitness.model.dto.AddObjectiveRequestDto;
import com.adoo.colemanfitness.service.AthleteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("athlete")
@AllArgsConstructor
public class AthleteController {

    private final AthleteService athleteService;

    @PostMapping("/add")
    public ResponseEntity<Object> addAthlete(@RequestBody AddAthleteRequestDto request) {
        return athleteService.addAthlete(request);
    }

    @GetMapping("/getAthletes")
    public ResponseEntity<Object> getAthletes() {
        return athleteService.getAthletes();
    }

    @GetMapping("/getAthlete/{id}")
    public ResponseEntity<Object> getAthlete(@PathVariable Long id) {
        return athleteService.getAthleteId(id);
    }

    @PostMapping("/setObjective")
    public ResponseEntity<Object> setObjective(@RequestBody AddObjectiveRequestDto request) {
        return athleteService.setObjective(request);
    }

    // Método para iniciar sesión
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String email, @RequestParam String password) {
        return athleteService.login(email, password);
    }
}