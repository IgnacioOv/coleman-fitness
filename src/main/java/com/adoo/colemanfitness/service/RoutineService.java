package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddRoutineRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.Objective;
import com.adoo.colemanfitness.model.entity.Routine;
import com.adoo.colemanfitness.model.entity.Training;
import com.adoo.colemanfitness.repository.ObjectiveJpaRepository;
import com.adoo.colemanfitness.repository.RoutineJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoutineService {

    @Autowired
    private RoutineJpaRepository routineRepository;

    @Autowired
    private ObjectiveJpaRepository objectiveRepository;

    public List<AddRoutineRequestDto> getAllRoutines() {
        return routineRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AddRoutineRequestDto getRoutineById(Long id) {
        return routineRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public DefaultResponseDto createRoutine(AddRoutineRequestDto routineDto) { //generar
        Routine routine = convertToEntity(routineDto);
        routineRepository.save(routine);
        //routine.setTrainingList();
        return new DefaultResponseDto("Routine created successfully", HttpStatus.CREATED);
    }

    public DefaultResponseDto updateRoutine(Long id, AddRoutineRequestDto routineDto) {
        Routine routine = routineRepository.findById(id).orElse(null);
        if (routine != null) {
            if (routineDto.getObjectiveId() != null) {
                Objective objective = objectiveRepository.findById(routineDto.getObjectiveId()).orElse(null);
                routine.setObjective(objective);
            }
            routineRepository.save(routine);
            return new DefaultResponseDto("Routine updated successfully", HttpStatus.OK);
        }
        return new DefaultResponseDto("Routine not found", HttpStatus.NOT_FOUND);
    }

    public DefaultResponseDto deleteRoutine(Long id) {
        if (routineRepository.existsById(id)) {
            routineRepository.deleteById(id);
            return new DefaultResponseDto("Routine deleted successfully", HttpStatus.OK);
        }
        return new DefaultResponseDto("Routine not found", HttpStatus.NOT_FOUND);
    }

    private AddRoutineRequestDto convertToDto(Routine routine) {
        return new AddRoutineRequestDto(
                routine.getObjective() != null ? routine.getObjective().getId() : null
        );
    }

    private Routine convertToEntity(AddRoutineRequestDto routineDto) {
        Routine routine = new Routine();
        if (routineDto.getObjectiveId() != null) {
            Objective objective = objectiveRepository.findById(routineDto.getObjectiveId()).orElse(null);
            routine.setObjective(objective);
        }
        return routine;
    }


}
