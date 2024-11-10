package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.RequestExcerciseDto;
import com.adoo.colemanfitness.model.entity.Excercise;
import com.adoo.colemanfitness.model.entity.ExcerciseServiceInterface;
import com.adoo.colemanfitness.repository.ExcerciseJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExcerciseService implements ExcerciseServiceInterface {

    ExcerciseJpaRepository excerciseJpaRepository;

    public List<Excercise> getExcerciseByParameters(RequestExcerciseDto request){
        return excerciseJpaRepository.findByMuscleGroupAndAerobicLevelBetween(request.getMuscle(), request.getMinAerobicLevel(), request.getMaxAerobicLevel());
    }



}
