package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.entity.Trophy;
import com.adoo.colemanfitness.repository.TrophyJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/trophies")
public class TrophyController {

    @Autowired
    private TrophyJpaRepository trophyJpaRepository;

    // Endpoint para obtener todos los trofeos
    @GetMapping("/all")
    public ResponseEntity<List<Trophy>> getAllTrophies() {
        List<Trophy> trophies = trophyJpaRepository.findAll();

        // Opcional: Convertir a DTO o filtrar propiedades según sea necesario
        List<Trophy> simplifiedTrophies = trophies.stream()
                .map(trophy -> {
                    trophy.setAthlete(null); // Elimina la referencia al atleta para evitar la anidación
                    return trophy;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(simplifiedTrophies);
    }
}
