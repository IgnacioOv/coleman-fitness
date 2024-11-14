package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.RequestExcerciseDto;
import com.adoo.colemanfitness.model.dto.RoutineResponseDto;
import com.adoo.colemanfitness.model.entity.Excercise;
import com.adoo.colemanfitness.model.entity.ExcerciseServiceInterface;
import com.adoo.colemanfitness.model.entity.Routine;
import com.adoo.colemanfitness.repository.ExcerciseJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExcerciseService{

    ExcerciseJpaRepository excerciseJpaRepository;

    public List<Excercise> getExcerciseByParameters(RequestExcerciseDto request){
        Pageable pageable = PageRequest.of(0,2);
        return excerciseJpaRepository.findByMuscleGroupAndAerobicLevelBetween(request.getMuscle(), request.getMinAerobicLevel(), request.getMaxAerobicLevel(),pageable);
    }


}
