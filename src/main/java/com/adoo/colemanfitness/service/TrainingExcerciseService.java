package com.adoo.colemanfitness.service;

import com.adoo.colemanfitness.model.dto.AddTrainingExcerciseRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.model.entity.Excercise;
import com.adoo.colemanfitness.model.entity.Training;
import com.adoo.colemanfitness.model.entity.TrainingExcercise;
import com.adoo.colemanfitness.repository.ExcerciseJpaRepository;
import com.adoo.colemanfitness.repository.TrainingJpaRepository;
import com.adoo.colemanfitness.repository.TrainingExcerciseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingExcerciseService {




    public TrainingExcercise generateTrainingExcercise(){
        // busco en la db segun los parametros solicitados, construyo el training excercise con reps y peso

    }


}
