package com.adoo.colemanfitness.repository;

import com.adoo.colemanfitness.model.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoutineJpaRepository extends JpaRepository<Routine, Long> {

    List<Routine> findTopByObjective_Athlete_IdOrderByIdDesc(Long athleteId);

}
