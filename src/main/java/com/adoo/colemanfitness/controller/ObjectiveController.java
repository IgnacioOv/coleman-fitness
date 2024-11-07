package com.adoo.colemanfitness.controller;

import com.adoo.colemanfitness.model.dto.AddObjectiveRequestDto;
import com.adoo.colemanfitness.model.dto.DefaultResponseDto;
import com.adoo.colemanfitness.service.ObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objectives")
public class ObjectiveController {

    @Autowired
    private ObjectiveService objectiveService;

}
