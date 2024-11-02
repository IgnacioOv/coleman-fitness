package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddObjectiveRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.Athlete;
import com.adoo.colemanfitness.model.entity.Objective;
import com.adoo.colemanfitness.repository.AthleteJpaRepository;
import com.adoo.colemanfitness.repository.ObjectiveJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectiveService {

    @Autowired
    private ObjectiveJpaRepository objectiveRepository;

    @Autowired
    private AthleteJpaRepository athleteRepository;

    public List<AddObjectiveRequestDto> getAllObjectives() {
        return objectiveRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AddObjectiveRequestDto getObjectiveById(Long id) {
        return objectiveRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public DefaultResponseDto createObjective(AddObjectiveRequestDto objectiveDto) {
        Objective objective = convertToEntity(objectiveDto);
        objectiveRepository.save(objective);
        return new DefaultResponseDto("Objective created successfully", HttpStatus.CREATED);
    }

    public DefaultResponseDto updateObjective(Long id, AddObjectiveRequestDto objectiveDto) {
        Objective objective = objectiveRepository.findById(id).orElse(null);
        if (objective != null) {
            if (objectiveDto.getAthleteId() != null) {
                Athlete athlete = athleteRepository.findById(objectiveDto.getAthleteId()).orElse(null);
                objective.setAthlete(athlete);
            }
            objectiveRepository.save(objective);
            return new DefaultResponseDto("Objective updated successfully", HttpStatus.OK);
        }
        return new DefaultResponseDto("Objective not found", HttpStatus.NOT_FOUND);
    }

    public DefaultResponseDto deleteObjective(Long id) {
        if (objectiveRepository.existsById(id)) {
            objectiveRepository.deleteById(id);
            return new DefaultResponseDto("Objective deleted successfully", HttpStatus.OK);
        }
        return new DefaultResponseDto("Objective not found", HttpStatus.NOT_FOUND);
    }

    private AddObjectiveRequestDto convertToDto(Objective objective) {
        return new AddObjectiveRequestDto(
                objective.getAthlete() != null ? objective.getAthlete().getId() : null
        );
    }

    private Objective convertToEntity(AddObjectiveRequestDto objectiveDto) {
        Objective objective = new Objective() {
            // Puede ser una implementación vacía o clase concreta dependiendo del uso
        };

        if (objectiveDto.getAthleteId() != null) {
            Athlete athlete = athleteRepository.findById(objectiveDto.getAthleteId()).orElse(null);
            objective.setAthlete(athlete);
        }

        return objective;
    }
}
