package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.*;
import com.adoo.colemanfitness.repository.AthleteJpaRepository;
import com.adoo.colemanfitness.repository.TrophyJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TrophyService {

    TrophyJpaRepository trophyJpaRepository;
    AthleteJpaRepository athleteJpaRepository;

    private Trophy determineTrophy(String trophyType) {
        return switch (trophyType) {
            case "dedication" -> new DedicationTrophy();
            case "constancy" -> new ConstancyTrophy();
            case "vanity" -> new VanityTrophy();
            default -> throw new IllegalArgumentException("Trofeo no valido");
        };
    }

    public void verify(String trophyType, Long athleteId){
        try{
            Trophy createTrophy = determineTrophy(trophyType);
            Athlete athlete = athleteJpaRepository.findById(athleteId).orElseThrow(() ->
                    new IllegalArgumentException("Atleta no encontrado para ID: " + athleteId)
            );
            Boolean verifyAddTrophy = createTrophy.verifyTrophy(athlete);
            if (verifyAddTrophy){
                addTrophy(athlete, createTrophy);
                NotificadorService.sendNotificacion("Has obtenido el trofeo " + trophyType + " segui asi!");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public ResponseEntity<Object> addTrophy(Athlete athlete, Trophy trophy) {
        try {
            trophy.setAthlete(athlete);
            trophyJpaRepository.save(trophy);
            DefaultResponseDto response = new DefaultResponseDto();
            response.setCode(HttpStatus.OK);
            response.setMessage("Trofeo guardado correctamente");
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e) {
            DefaultResponseDto response = new DefaultResponseDto();
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
