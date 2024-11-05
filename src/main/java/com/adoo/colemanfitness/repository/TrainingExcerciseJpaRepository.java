package com.adoo.colemanfitness.repository;

import com.adoo.colemanfitness.model.entity.TrainingExcercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingExcerciseJpaRepository extends JpaRepository<TrainingExcercise, Long> {
    // Métodos de consulta personalizados se pueden agregar aquí si es necesario
}
