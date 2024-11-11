package com.adoo.colemanfitness.repository;

import com.adoo.colemanfitness.model.entity.Excercise;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcerciseJpaRepository extends JpaRepository<Excercise, Long> {

    List<Excercise> findByMuscleGroupAndAerobicLevelBetween(String muscle, Float minAerobicLevel, Float maxAerobicLevel, Pageable pageable);


}
