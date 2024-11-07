package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddExcerciseRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.dto.RequestExcerciseDto;
import com.adoo.colemanfitness.model.entity.Excercise;
import com.adoo.colemanfitness.repository.ExcerciseJpaRepository;
import com.adoo.colemanfitness.util.MuscleGroupEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExcerciseService {

    ExcerciseJpaRepository excerciseJpaRepository;

    public List<Excercise> getExcerciseByParameters(RequestExcerciseDto request){
        return excerciseJpaRepository.findByMuscleGroupAndAerobicLevelBetween(request.getMuscle(), request.getMinAerobicLevel(), request.getMaxAerobicLevel());
    }



}
