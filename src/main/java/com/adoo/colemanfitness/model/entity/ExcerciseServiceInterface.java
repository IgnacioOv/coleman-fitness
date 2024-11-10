package com.adoo.colemanfitness.model.entity;

import com.adoo.colemanfitness.model.dto.RequestExcerciseDto;
import java.util.List;
public interface ExcerciseServiceInterface {
    List<Excercise> getExcerciseByParameters(RequestExcerciseDto request);

}
