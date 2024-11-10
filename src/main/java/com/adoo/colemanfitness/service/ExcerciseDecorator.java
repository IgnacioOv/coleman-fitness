package com.adoo.colemanfitness.service;
import com.adoo.colemanfitness.model.dto.RequestExcerciseDto;
import com.adoo.colemanfitness.model.entity.Excercise;
import com.adoo.colemanfitness.model.entity.ExcerciseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcerciseDecorator implements ExcerciseServiceInterface {
    private final ExcerciseServiceInterface excerciseService;

    @Autowired
    public ExcerciseDecorator(ExcerciseServiceInterface excerciseService) {
        this.excerciseService = excerciseService;
    }

    @Override
    public List<Excercise> getExcerciseByParameters(RequestExcerciseDto request) {
        List<Excercise> result = excerciseService.getExcerciseByParameters(request);
        for (Excercise excercise : result) {
            // Aumentar los sets y reps en un 10%
            long updatedSets = (long) Math.ceil(excercise.getSets() * 1.2);
            long updatedReps = (long) Math.ceil(excercise.getReps() * 1.2);

            excercise.setSets(updatedSets);
            excercise.setReps(updatedReps);

        }

        return result;
    }

}
