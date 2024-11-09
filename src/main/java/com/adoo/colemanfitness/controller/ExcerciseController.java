package com.adoo.colemanfitness.controller;
import com.adoo.colemanfitness.model.dto.RequestExcerciseDto;
import com.adoo.colemanfitness.service.ExcerciseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/excercise")
@AllArgsConstructor
public class ExcerciseController {

    private ExcerciseService excerciseService;

    @PostMapping("/get")
    public ResponseEntity<Object> getExcerciseByParameters(@RequestBody RequestExcerciseDto request){
        return new ResponseEntity<>(excerciseService.getExcerciseByParameters(request), HttpStatus.OK);
    }
}
